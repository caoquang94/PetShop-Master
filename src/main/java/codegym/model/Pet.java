package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pet")
public class Pet implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long age;
    private String weight;
    private String color;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @ManyToMany(targetEntity = CareDetail.class)
    private Set<CareDetail> careDetails;

    @ManyToOne
    @JoinColumn(name = "petKind_id")
    private PetKind petKind;

    public void setPetKind(PetKind petKind) {
        this.petKind = petKind;
    }

    public PetKind getPetKind() {
        return petKind;
    }

    public Set<CareDetail> getCareDetails() {
        return careDetails;
    }

    public Set<MyTeam> getMyTeams() {
        return myTeams;
    }

    public void setCareDetails(Set<CareDetail> careDetails) {
        this.careDetails = careDetails;
    }

    public void setMyTeams(Set<MyTeam> myTeams) {
        this.myTeams = myTeams;
    }

    @ManyToMany(targetEntity = MyTeam.class)
    private Set<MyTeam> myTeams;

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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Pet.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Pet pet = (Pet) target;
        String petName = pet.getName();
        Long petAge = pet.getAge();
        String petWeight = pet.getWeight();
        String petColor = pet.getColor();
        ValidationUtils.rejectIfEmpty(errors, "petName", "petName.empty");
        ValidationUtils.rejectIfEmpty(errors, "petWeight", "petWeight.empty");
        ValidationUtils.rejectIfEmpty(errors, "petColor", "petColor.empty");
        if (petAge==null)
            errors.rejectValue("petAge","petAge.empty");
    }
}
