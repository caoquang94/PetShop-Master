package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "myteam")
public class MyTeam implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToMany(targetEntity = Pet.class)
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MyTeam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyTeam myTeam = (MyTeam) target;
        String teamNumber = myTeam.getNumber();
        String teamName = myTeam.getName();
        ValidationUtils.rejectIfEmpty(errors, "teamNumber", "teamNumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "teamName", "teamName.empty");
        if (teamNumber.length() >11 || number.length() < 10){
            errors.rejectValue("teamNumber", "teamNumber.length");
        }
        if (!teamNumber.startsWith("0")){
            errors.rejectValue("teamNumber", "teamNumber.startsWith");
        }
        if (!teamNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("teamNumber", "teamNumber.matches");
        }

    }
}
