package com.tenco.blog_v1.board;

import lombok.Data;
import org.apache.catalina.User;

public class BoardDTO {

    @Data
    public static class SaveDTO {
        private String title;
        private String content;

        public Board toEntity(org.apache.catalina.User user) {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(user)
                    .build();
        }

    }

    @Data
    public static class UpdateDTO {
        private String username;
        private String title;
        private String content;
    }
}