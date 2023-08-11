package com.example.football.models.dto;

import com.example.football.models.entity.PlayerPossition;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerDTO {
/*        <player>
        <first-name>L</first-name>
        <last-name>Smallbone</last-name>
        <email>lsmallbone0@hubpages.com</email>
        <birth-date>21/02/1979</birth-date>
        <position>ATT</position>
        <town>
            <name>Kazan</name>
        </town>
        <team>
            <name>McGlynn</name>
        </team>
        <stat>
            <id>53</id>
        </stat>
    </player>       */

    @XmlElement(name = "first-name")
    @Size(min=2)
    private String firstName;

    @XmlElement(name= "last-name")
    @Size(min = 2)
    private String lastName;

    @XmlElement
    @Email
    private String email;



    //dd/MM/yyyy
    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement
    private PlayerPossition possition;

    @XmlElement(name="town")
    private NameDTO town;

    @XmlElement(name="team")
    private NameDTO team;

    @XmlElement(name = "stat")
    private StatIdDTO stat;

    public ImportPlayerDTO() {
    }

    public ImportPlayerDTO(String firstName, String lastName, String email, String birthDate, PlayerPossition possition, NameDTO town, NameDTO team, StatIdDTO stat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.possition = possition;
        this.town = town;
        this.team = team;
        this.stat = stat;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PlayerPossition getPossition() {
        return possition;
    }

    public NameDTO getTown() {
        return town;
    }

    public NameDTO getTeam() {
        return team;
    }

    public StatIdDTO getStat() {
        return stat;
    }

}
