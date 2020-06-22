package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pettype")
public class PetType implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<PetKind> getPetKinds() {
        return petKinds;
    }

    public void setPetKinds(Set<PetKind> petKinds) {
        this.petKinds = petKinds;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = PetKind.class)
    private Set<PetKind> petKinds;
    @Override
    public boolean supports(Class<?> clazz) {
        return PetType.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    PetType petType = (PetType) target;
    String petTypeName = petType.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "petTypeName.empty");
        if (!petTypeName.matches("^$|[A-Za-z]*$")){
            errors.rejectValue("name","petTypeName.matches");
        }
    }
}
