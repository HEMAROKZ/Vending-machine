package com.VendingMachine.VendingMachine01.dao;

import com.VendingMachine.VendingMachine01.dto.InventoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.VendingMachine.VendingMachine01.model.Inventry;

import java.util.List;

@Repository
public class InventoryDAOImp implements InventoryDAO {

    @Autowired
   JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }


    @Override
    public List<Inventry> findAll() {
        String SQL ="SELECT * FROM productlist";
        return getNamedParameterJdbcTemplate().query(SQL, new BeanPropertyRowMapper<Inventry>(Inventry.class));
    }

    @Override
    public List<Inventry> findById(int productId) {
        SqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("productid", productId);
        return getNamedParameterJdbcTemplate().query("SELECT * FROM productlist WHERE productid = :productid ", mapSqlParameterSource , new BeanPropertyRowMapper<Inventry>(Inventry.class));
    }
    ///////////////////////////////////////////////////////////
    @Override
    public List<Inventry> findByInventryCount(int productInventryCount) {
        SqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("productinventrycount", productInventryCount);
        return getNamedParameterJdbcTemplate().query("SELECT * FROM productlist WHERE productinventrycount > :productinventrycount ", mapSqlParameterSource , new BeanPropertyRowMapper<Inventry>(Inventry.class));
    }
    //////////////////////////////////////////////////////////
    @Override
    public int  save(InventoryDTO e) {
        String sql ="INSERT INTO productlist (productid,name, productinventrycount, productprice) VALUES (:productid,:name, :productinventrycount,:productprice)";
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("productid", e.getProductId());
        paramSource.addValue("name", e.getName());
        paramSource.addValue("productinventrycount",e.getProductInventryCount());
        paramSource.addValue("productprice", e.getProductPrice());

//        int update = getNamedParameterJdbcTemplate().update(sql, paramSource);
//        if(update == 1) {
//            System.out.println("product is added..");
//        }
        return  namedParameterJdbcTemplate.update(sql, paramSource);
    }

    @Override
    public int updatedStock(int productId, int productInventryCount) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("productid", productId).addValue("productinventrycount", productInventryCount);
        return getNamedParameterJdbcTemplate().update("update productlist set productinventrycount = :productinventrycount where productid = :productid", sqlParameterSource);
    }



    @Override
    public int deleteById(int productId) {
        return jdbcTemplate.update("DELETE FROM productlist WHERE productid=?", productId);
    }

//    @Override
//    public int update(Inventry e, int productId) {
//        return jdbcTemplate.update("UPDATE productlist SET name = ?, productinventrycount = ?, productprice = ? WHERE productid = ?", new Object[] {e.getName(), e.getProductInventryCount(), e.getProductPrice(), productId});
//    }
//
//    @Override
//    public int update(InventoryDTO e) {
//                String sql ="update productlist set name= :name, productinventrycount= :productinventrycount, productprice=:productprice where productid= :productid ";
//        SqlParameterSource paramSource = new MapSqlParameterSource().addValue("productid", e.getProductId()).addValue("name", e.getName()).addValue("productinventrycount",e.getProductInventryCount()).addValue("productprice", e.getProductPrice());
//        System.out.println("here in inventorydtoimp ========================");
//
////        int update = getNamedParameterJdbcTemplate().update(sql, paramSource);
////        if(update == 1) {
////            System.out.println("product is added..");
////        }
//        return  namedParameterJdbcTemplate.update(sql, paramSource);
//   }
//====================referense=============================
//    public void updatePerson(Person p) {
//        String sql = "update person set name = :name, age = :age ;
//        SqlParameterSource paramSource = new MapSqlParameterSource().addValue("name", p.getName())
//                .addValue("age", p.getAge()).addValue("id", p.getId());
//        namedParameterJdbcTemplate.update(sql, paramSource);
//    }
//====================referense=============================
//
    @Override
    public int update(Inventry e) {
        String sql ="update productlist set name= :name, productinventrycount= :productinventrycount, productprice=:productprice where productid= :productid ";
        SqlParameterSource paramSource = new MapSqlParameterSource().addValue("productid", e.getProductId()).addValue("name", e.getName()).addValue("productinventrycount",e.getProductInventryCount()).addValue("productprice", e.getProductPrice());
        System.out.println("here in inventorydtoimp ========================");
        return  namedParameterJdbcTemplate.update(sql, paramSource);
    }

}
