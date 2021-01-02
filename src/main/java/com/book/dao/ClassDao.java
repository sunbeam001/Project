package com.book.dao;

import com.book.domain.Book;
import com.book.domain.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Repository
public class ClassDao {
    private JdbcTemplate jdbcTemplate;

    /*图书类型数据库操作类*/
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String QUERY_ALL_CLASS_SQL = "SELECT * FROM class_info ";

    public ArrayList<ClassInfo> getAll() {
        final ArrayList<ClassInfo> books = new ArrayList<ClassInfo>();

        jdbcTemplate.query(QUERY_ALL_CLASS_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    ClassInfo book = new ClassInfo();
                    book.setId(resultSet.getString("class_id"));
                    book.setName(resultSet.getString("class_name"));
                    books.add(book);
                }
            }
        });
        return books;

    }
}
