package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "caretype")
public class CareType implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(targetEntity = CareDetail.class)
    private Set<CareDetail> careDetails;

    public Set<CareDetail> getCareDetails() {
        return careDetails;
    }

    public void setCareDetails(Set<CareDetail> careDetails) {
        this.careDetails = careDetails;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return CareType.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CareType careType = (CareType) target;
        String careTypeName = careType.getName();
        ValidationUtils.rejectIfEmpty(errors, "careTypeName", "careTypeName.empty");
        if (!careTypeName.matches("^$|[A-Za-z]*$")){
            errors.rejectValue("name","careTypeName.matches");
        }
    }
}
