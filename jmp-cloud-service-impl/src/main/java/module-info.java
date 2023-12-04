module org.module.cloudservice {
    requires transitive org.module.serviceapi;
    requires org.module.dto;
    provides org.module.serviceapi with org.module.cloudservice;
    exports org.module.cloudservice;
}