package entity;

import entity.enumeration.Mode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Mode mode;
    @ManyToOne
    private User user;
}
