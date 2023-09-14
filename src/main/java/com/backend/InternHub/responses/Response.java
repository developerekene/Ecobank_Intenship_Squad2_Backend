package com.backend.InternHub.responses;

import lombok.Data;

@Data
public class Response {

        private String message;

        public Response(String message) {
            this.message = message;
        }

}
