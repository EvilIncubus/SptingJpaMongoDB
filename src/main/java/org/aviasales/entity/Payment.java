package org.aviasales.entity;

import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private int paymentCardId;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDateTime;
    private int reservationPaymentId;
}
