package com.btto.core.mock;

import com.btto.core.domain.Company;
import com.btto.core.domain.User;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockCompanyBuilder {
    private final Integer companyId;

    private String name;
    private Set<User> users;
    private boolean enabled = true;

    public MockCompanyBuilder(Integer companyId) {
        this.companyId = companyId;
    }

    public MockCompanyBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MockCompanyBuilder users(Set<User> users) {
        this.users = users;
        return this;
    }

    public MockCompanyBuilder users(User... users) {
        this.users = ImmutableSet.copyOf(users);
        return this;
    }

    public MockCompanyBuilder disabled() {
        this.enabled = false;
        return this;
    }

    public Company build() {
        final Company company = mock(Company.class);
        when(company.getId()).thenReturn(companyId);
        if (name != null) {
            when(company.getName()).thenReturn(name);
        }
        if (users != null) {
            when(company.getUsers()).thenReturn(users);
        }
        when(company.isEnabled()).thenReturn(enabled);
        return company;
    }
}
