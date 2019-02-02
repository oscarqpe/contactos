package com.oscarqpe.contacts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oscarqpe.contacts.dto.Contact;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Contact(rs.getLong("ID"), rs.getString("FIRST_NAME"), 
        		rs.getString("LAST_NAME"), rs.getString("PHONE_NUMBER"), rs.getString("EMAIL"));
    }
}