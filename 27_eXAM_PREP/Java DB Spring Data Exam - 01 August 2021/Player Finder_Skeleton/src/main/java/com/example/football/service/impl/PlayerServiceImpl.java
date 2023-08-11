package com.example.football.service.impl;

import com.example.football.models.dto.ImportPlayerDTO;
import com.example.football.models.dto.ImportPlayerRootDTO;
import com.example.football.models.dto.ImportStatRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//ToDo - Implement all methods
@Service
public class PlayerServiceImpl implements PlayerService {

    private final Path path =
            Path.of("src", "main", "resources", "files", "xml", "players.xml" );

    private final PlayerRepository playerRepository;
    private final TypeMap<ImportPlayerDTO, Player> dtoToPlayerMapper;

    private TeamRepository teamRepository;
    private TownRepository townRepository;
    private StatRepository statRepository;
    private final Unmarshaller unmashaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository,
                             TeamRepository teamRepository,StatRepository statRepository) throws JAXBException {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;

        JAXBContext context = JAXBContext.newInstance(ImportPlayerRootDTO.class);
        this.unmashaller = context.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();

        Converter<String , LocalDate> toLocalDate = s -> s.getSource() == null ? null :
                LocalDate.parse(s.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        modelMapper.addConverter(toLocalDate);

        TypeMap<ImportPlayerDTO, Player> typeMap = this.modelMapper.createTypeMap(ImportPlayerDTO.class, Player.class);

       this.dtoToPlayerMapper = typeMap.addMappings(map ->
                map.using(toLocalDate).map(ImportPlayerDTO::getBirthDate, Player::setBirthDate));
    }


    @Override
    public boolean areImported() {

        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(path);

    }

    @Override
    public String importPlayers() throws FileNotFoundException, JAXBException {

        ImportPlayerRootDTO playerDTOs = (ImportPlayerRootDTO) this.unmashaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

           return playerDTOs.getPlayers().
                    stream()
                    .map(this::importPlayer)
                     .collect(Collectors.joining("\n"));


    }

    private String importPlayer(ImportPlayerDTO dto) {
        Set<ConstraintViolation<ImportPlayerDTO>> errors =
                this.validator.validate(dto);

        if(!errors.isEmpty()) {
            return "Invalid Player";
        }

        Optional <Player> optPlayer = this.playerRepository.findByEmail(dto.getEmail());

        if(optPlayer.isPresent()) {
            return "invalid Player";
        }

        Optional<Team> team = this.teamRepository.findByName(dto.getTeam().getName());
        Optional<Town> town = this.townRepository.findByName(dto.getTown().getName());
        Optional<Stat> stat = this.statRepository.findById(dto.getStat().getId());

        Player player = this.dtoToPlayerMapper.map(dto);

        player.setTown(town.get());
        player.setTeam(team.get());
        player.setStat(stat.get());

        this.playerRepository.save(player);

        return "Successfully imported Player " +player.getFirstName() + " " +
                player.getLastName() + " - " + player.getPosition().toString();

    }

    @Override
    public String exportBestPlayers() {
        return null;
    }
}
