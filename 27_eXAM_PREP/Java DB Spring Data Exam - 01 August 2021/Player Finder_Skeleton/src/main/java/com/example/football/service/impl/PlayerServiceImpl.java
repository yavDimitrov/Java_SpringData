package com.example.football.service.impl;

import com.example.football.models.dto.ImportPlayerRootDTO;
import com.example.football.models.dto.ImportStatRootDTO;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//ToDo - Implement all methods
@Service
public class PlayerServiceImpl implements PlayerService {

    private final Path path =
            Path.of("src", "main", "resources", "files", "xml", "players.xml" );

    private final PlayerRepository playerRepository;
    private final Unmarshaller unmashaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) throws JAXBException {
        this.playerRepository = playerRepository;

        JAXBContext context = JAXBContext.newInstance(ImportPlayerRootDTO.class);
        this.unmashaller = context.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();
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
        return null;
    }

    @Override
    public String exportBestPlayers() {
        return null;
    }
}
