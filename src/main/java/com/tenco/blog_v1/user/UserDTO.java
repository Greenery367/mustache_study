package com.tenco.blog_v1.user;

import lombok.Data;

@Data
public class UserDTO {

    @Data
    public static class LoginDTO{
        private String username;
        private String password;
    }

    @Data
    public static class JoinDTO{
        private String username;
        private String passsword;
        private String email;

        public User toEntity(){
            return User.builder()
                    .username(this.username)
                    .passsword(this.passsword)
                    .email(this.email)
                    .build();
        }
    }
}
