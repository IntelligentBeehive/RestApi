module beerestapi {
    requires java.sql;
    requires gson;
    requires javax.ws.rs.api;
    requires jetty.servlet;
    requires jetty.server;
    requires jersey.container.servlet.core;
    requires javax.servlet.api;

    exports server;
}