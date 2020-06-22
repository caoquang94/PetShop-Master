package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "petkind")
public class PetKind implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @ManyToOne
    @JoinColumn(name = "petType_id")
    private PetType petType;

    @OneToMany(targetEntity = Pet.class)
    private Set<Pet> pets;

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public PetType getPetType() {
        return petType;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return PetKind.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PetKind petKind = (PetKind) target;
        String kindName = petKind.getName();
        String status = petKind.getStatus();
        ValidationUtils.rejectIfEmpty(errors, "kindName", "kindName.empty");
        ValidationUtils.rejectIfEmpty(errors, "status", "status.empty");
    }
}
