package com.example.alexander.applicationtask3;

import java.util.List;

/**
 * Created by Alexander on 12/23/2015.
 */
public class Users {

    public List<UserItem> users;

    public List<UserItem> getUsers() { return users; }

    public void setUsers(List<UserItem> users) { this.users = users; }

    public Users(List<UserItem> users) { this.users = users; }

    public class UserItem {
        private int id;
        private String email;
        private String password;
        private String token_auth;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken_auth() {
            return token_auth;
        }

        public void setToken_auth(String token_auth) {
            this.token_auth = token_auth;
        }
    }
}
