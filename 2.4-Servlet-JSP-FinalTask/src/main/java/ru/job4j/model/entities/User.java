package ru.job4j.model.entities;

import java.util.List;

/**
 * User. Builder pattern.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class User extends BaseEntity {
    private String login;
    private String password;
    private Role role;
    private Address address;
    private List<MusicStyle> musicStyles;

    /**
     * Getter for login.
     * @return  login
     */
    public String getLogin() {
        return login;
    }
    /**
     * Getter for password.
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Getter for role.
     * @return role
     */
    public Role getRole() {
        return role;
    }
    /**
     * Getter for address.
     * @return address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * Getter for musicStyle
     * @return list
     */
    public List<MusicStyle> getMusicStyles() {
        return musicStyles;
    }

    /**
     * Constructor.
     * @param builder builder.
     */
    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.login = builder.login;
        this.password = builder.password;
        this.role = builder.role;
        this.address = builder.address;
        this.musicStyles = builder.musicStyles;
    }

    /**
     * Inner static class Builder.
     */
    public static class Builder  {
        private String login;
        private int id = 0;
        private String name = null;
        private String password = null;
        private Role role = null;
        private Address address = null;
        private List<MusicStyle> musicStyles = null;

        /**
         * Base constructor.
         * @param login login
         */
        public Builder(String login) {
            this.login = login;
        }

        /**
         * set id.
         * @param id id
         * @return builder
         */
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * set name.
         * @param name name
         * @return builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set password.
         * @param password password
         * @return builder
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * Set role.
         * @param role role
         * @return builder
         */
        public Builder role(Role role) {
            this.role = role;
            return this;

        }

        /**
         * set address.
         * @param address address
         * @return builder.
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Set music style
         * @param musicStyles music style
         * @return builder.
         */
        public Builder music(List<MusicStyle> musicStyles) {
            this.musicStyles = musicStyles;
            return this;
        }

        /**
         * Create user use builder.
         * @return user
         */
        public User build() {
            return new User(this);
        }
    }
}
