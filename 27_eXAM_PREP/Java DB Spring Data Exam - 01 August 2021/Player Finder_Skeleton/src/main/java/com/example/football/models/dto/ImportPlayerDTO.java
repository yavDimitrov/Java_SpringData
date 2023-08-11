package com.example.football.models.dto;

import com.example.football.models.entity.PlayerPossition;

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
    private String firstName;

    @XmlElement(name= "last-name")
    private String lastName;

    @XmlElement
    private String email;

    @XmlElement(name = "birth-date")
    private LocalDate birthDate;

    @XmlElement
    private PlayerPossition possition;

    @XmlElement(name="town")
    private NameDTO town;

    @XmlElement(name="team")
    private NameDTO team;

    @XmlElement(name = "stat")
    private StatIdDTO stat;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
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
