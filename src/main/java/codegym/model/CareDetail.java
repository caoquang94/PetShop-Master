package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "caredetail")
public class CareDetail implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String price;
    private String time;

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @ManyToOne
    @JoinColumn(name = "careType_id")
    private CareType careType;

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }

    @ManyToMany(targetEntity = Pet.class)
    private Set<Pet> pets;
    @Override
    public boolean supports(Class<?> clazz) {
        return CareDetail.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CareDetail careDetail = (CareDetail) target;
        String careDetailName = careDetail.getName();
        String careDetailPrice = careDetail.getPrice();
        String careDetailTime = careDetail.getTime();
        ValidationUtils.rejectIfEmpty(errors, "careDetailName","careDetailName.empty");
        ValidationUtils.rejectIfEmpty(errors, "careDetailPrice","careDetailPrice.empty");
        ValidationUtils.rejectIfEmpty(errors, "careDetailTime","careDetailTime.empty");

        if (!careDetailPrice.matches("^$|[0-9]*$")){
            errors.rejectValue("price","careDetailPrice.matches");
        }
    }
}
