package com.gtbsa.LMS.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Login {

    @NotBlank(message = "username can not be empoty !! ")
    @Size(min=3, max= 12, message = "username must be 3 to 12 character !! ")
    private String userName;

    @Email(regexp="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message="Invalid email !!")
    private String email;

    @AssertTrue
    private boolean agree;

}
