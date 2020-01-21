package com.ping.domain;

import java.util.List;

public class QueryVo {
    private List<Integer> ids;
    private Users users;
    public List <Integer> getIds() {
        return ids;
    }

    public void setIds(List <Integer> ids) {
        this.ids = ids;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
