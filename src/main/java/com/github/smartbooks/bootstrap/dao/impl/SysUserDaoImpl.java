package com.github.smartbooks.bootstrap.dao.impl;

import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import com.github.smartbooks.bootstrap.dao.SysUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SysUserDaoImpl implements SysUserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public SysUser find(String userName) {
        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return null;
    }

    @Override
    public List<SysUser> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SysUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SysUser> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(SysUser sysUser) {

    }

    @Override
    public void deleteAll(Iterable<? extends SysUser> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SysUser> S save(S s) {
        return null;
    }

    @Override
    public <S extends SysUser> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<SysUser> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends SysUser> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<SysUser> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SysUser getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends SysUser> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SysUser> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SysUser> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SysUser> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SysUser> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SysUser> boolean exists(Example<S> example) {
        return false;
    }
}
