package com.petify.petplatform.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class URICreator {
    public static String getSelfLink(String id) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }

        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}
