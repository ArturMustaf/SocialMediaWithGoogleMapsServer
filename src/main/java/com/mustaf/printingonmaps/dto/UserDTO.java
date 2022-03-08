package com.mustaf.printingonmaps.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class UserDTO {
    private String googleAccId;
    private String name;
    private String surname;
    private String displayName;
    private String photoUrl;
    private String email;
}
