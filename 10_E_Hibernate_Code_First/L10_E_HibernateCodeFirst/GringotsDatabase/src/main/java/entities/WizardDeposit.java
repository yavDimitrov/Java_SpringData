package entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WizardDeposit {

    @Id
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String notes;

    @Column
    private int age;

    @Column
    private String magic_wand_creator;

    @Column
    private String magic_wand_size;

    @Column
    private String deposit_group;

    @Column
    private String deposit_startData;

    @Column
    private String deposit_amount;

    @Column
    private String deposit_interest;

    @Column
    private String deposit_charge;

    @Column
    private String deposit_expiration_date;

    @Column
    private String is_deposit_expired;


}
