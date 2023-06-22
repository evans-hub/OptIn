/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apptivate.OptIn.Utils;

/**
 * @author david
 */
public interface AppConstants {

    public interface Pagination {

        // Pagination default settings
        String DEFAULT_ORDER_DIRECTION = "DESC";
        String DEFAULT_PAGE_NUMBER = "0";
        String DEFAULT_PAGE_SIZE = "2147483647"; //Max Integer size
        String DEFAULT_ORDER_BY = "id";
        String DEFAULT_ORDER_BY_CODE = "code";
        String DEFAULT_COUNTRY = "KE";

        String DEFAULT_CLIENT_TYPE = "MCT";
        String DEFAULT_CLIENT_STATUS = "COMP";
        int MAX_PAGE_SIZE = 50;
    }

    public static class StakeholderType {

        public static final String USER = "USR";
        public static final String EMPLOYEE = "EMP";
    }

    public static class KafkaEvent {

        public static final String CREATE_UPDATE = "createUpdate";
        public static final String CREATE = "create";
        public static final String DELETE = "delete";
        public static final String DELETE_EMPLOYEE_CLIENT = "delete_eployee_client";
        public static final String AUTHORIZE = "authorized";
        public static final String COMPLETE = "completed";
        public static final String DISBURSEMENT = "disbursement";
        public static final String NO_ORDER = "no_order";
        public static final String ORDER_NOT_PAID = "order_not_paid";
        public static final String EXPIRED = "expired";
        public static final String CLIENT_EXPIRED = "client_expired";

    }

    public static class RoleType {

        public static final String APPTIVATE = "APVT";
        public static final String CLIENT = "CLT";
        public static final String MERCHANT = "MCT";
        public static final String EMPLOYEE = "EMP";
    }

    public static class ClientType {

        public static final String CLIENT = "CLT";
        public static final String MERCHANT = "MCT";
        public static final String OUTLET = "OTL";
    }

    public static class BusinessType {

        public static final String FRANCHISE = "FRCHS";
        public static final String STANDARD = "STD";
    }

    public static class TaxType {

        public static final String HAS_WITHHOLDING_TAX = "HWT";
        public static final String NO_WITHHOLDING_TAX = "NWT";
    }

    public static class StatusConst {

        public static final String PENDING = "PDNG";
        public static final String APPROVED = "APPR";
        public static final String COMPLETED = "COMP";
        public static final String PARTIALLY_COMPLETE = "PCOMP";
        public static final String REJECTED = "REJ";
        public static final String ACTIVE = "A";
    }

    public static class BranchCategory {

        public static final String HEADQUARTERS = "HQ";
        public static final String BRANCH = "BR";
    }

    public static class BranchType {

        public static final String BRANCH = "BR";
        public static final String OUTLET = "OTL";
    }

    public static class ControlType {

        public static final String RESTRICTED = "NR";
        public static final String STANDARD = "NS";
    }

    public static class RestrictType {

        public static final String ALLOWED = "A";
        public static final String BLOCKED = "B";
    }

    public static class DraftType {

        public static final String CLIENT_DRAFT = "CLTD";
        public static final String MERCHANT_DRAFT = "MCTD";
        public static final String CONTACT_PERSON_DRAFT = "CPD";
        public static final String FILE_DRAFT = "FD";
    }

    public static class Wallet {

        public static final String M_KULA = "MK";
        public static final String M_TUNZA = "MT";
        public static final String BUSINES_PASS = "BP";
        public static final String M_KAPU = "MP";
    }

    public static class LimitValueType {

        public static final String CURRENCY = "CURR";
        public static final String LITERAL_TYPE = "LTRL";
        public static final String OUTLET_VALUE_TYPE = "OTLT";
    }

    public static class Limits {

        public static final String NETWORK = "NTWK";
        public static final String DAYS_LIMIT = "DAYS";
        public static final String TRANSACTION_LIMIT = "NT";
        public static final String SPEND_LIMIT = "SP";
        public static final String PRODUCT_LIMIT = "PL";
    }

    public static class SettlementTypes {

        public static final String EXPRESS = "XPR";
        public static final String STANDARD = "STD";
    }

    public static class SettlementAt {

        public static final String SELF = "SELF";
        public static final String OUTLET = "BRANCH";
    }

    public interface LIMIT_TYPE {

        String PER_DAY = "PD";
        String PER_WEEK = "PW";
        String PER_MONTH = "PM";
    }

    public static class Duration {

        public static final String DAY = "Day";
        public static final String WEEK = "Week";
        public static final String MONTH = "Month";
    }

    public static class Relationships {

        public static final String AND_ABOVE = "AA";
        public static final String AND_BELOW = "AB";
        public static final String TO = "TO";
    }

    public static class UserStatus {

        public static final String ACTIVE = "A";
        public static final String PENDING = "P";
        public static final String SUSPENDED = "SP";
    }

    public static class DefaultFileType {

        public static final String PIN = "PIN";
        public static final String CERTIFICATE_OF_INCOOP = "COI";
    }

    public static class USER_TYPE {

        public static final String APPTIVATE = "APVT";
        public static final String CLIENT = "CLT";
        public static final String MERCHANT = "MCT";
        public static final String EMPLOYEE = "EMP";
    }

    public static class ENTITY_TYPE {

        public static final String APPTIVATE = "APVT";
        public static final String CLIENT = "CLT";
        public static final String MERCHANT = "MCT";
        public static final String OUTLET = "OTL";
        public static final String CLIENT_BRANCH = "BR";
        public static final String EMPLOYEE = "EMP";
        public static final String USER = "USR";
    }

    public static class SkybillStatus {

        public static final String PENDING = "pending";
        public static final String FAILED = "failed";
        public static final String CANCELLED = "cancelled";
        public static final String COMPLETED = "completed";
        public static final String TIMEDOUT = "999";
    }

    public static class Role {

        public static final String SUPER_ADMIN = "SA01";
        public static final String ADMIN = "AD01";
        public static final String CASHIER = "CA01";
        public static final String MERCHANT_CHECKER = "CH03";
        public static final String MERCHANT_MAKER = "MA03";
        public static final String CLIENT_CHECKER = "CH02";
        public static final String CLIENT_MAKER = "MA02";
        public static final String APTIVATE_CUSTOMER_SUPPORT = "CS01";
        public static final String EMPLOYEE = "EM01";
    }


}
