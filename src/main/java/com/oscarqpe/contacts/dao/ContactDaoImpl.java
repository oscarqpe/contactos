package com.oscarqpe.contacts.dao;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oscarqpe.contacts.dto.Contact;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
	@Autowired
    private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public ContactDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	@Override
	public List<Contact> getContactos() {
		return jdbcTemplate.query("SELECT * FROM CONTACT", new Object[] {}, new BeanPropertyRowMapper(Contact.class));
	}
	@Override
	public void createBatch(List<Contact> contactos) {
		String sql = "INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL) VALUES (?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, contactos, contactos.size(), 
				(PreparedStatement ps, Contact contact) -> {
					ps.setString(1, contact.getFirstName());
					ps.setString(2, contact.getLastName());
					ps.setString(3, contact.getPhoneNumber());
					ps.setString(4, contact.getEmail());
				});
	}
}
