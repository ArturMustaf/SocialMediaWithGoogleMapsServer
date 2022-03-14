package com.mustaf.socialmaps.dto;

import lombok.Getter;
import lombok.Setter;

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
