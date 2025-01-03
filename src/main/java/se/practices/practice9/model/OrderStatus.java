package se.practices.practice9.model;

/**
 * Represents the possible statuses of a customer order.
 */
public enum OrderStatus {
    PENDING,
    CONFIRMED,
    READY_FOR_DELIVERY,
    IN_DELIVERING,
    DELIVERED,
    CANCELED
}
