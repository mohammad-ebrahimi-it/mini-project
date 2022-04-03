package com.shop.shopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private Long id;
    private String name;
    private String persianName;

    public static class RuleResponseBuilder {
        private Long id;
        private String name;
        private String persianName;

        private RuleResponseBuilder() {

        }

        public static RuleResponseBuilder builder() {
            return new RuleResponseBuilder();
        }
        public RuleResponseBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public RuleResponseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RuleResponseBuilder setPersianName(String persianName) {
            this.persianName = persianName;
            return this;
        }

        public RoleResponse build() {
           return new RoleResponse(id, name, persianName);
        }

    }
}
