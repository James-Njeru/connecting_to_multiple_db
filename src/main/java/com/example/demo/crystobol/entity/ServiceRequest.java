package com.example.demo.crystobol.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "service_request")
@Getter
@Setter
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_cancelled")
    private boolean isCancelled;

    @Column(name = "cancelled_by")
    private Integer cancelledBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "date_cancelled")
    private Date dateCancelled;

    @Column(name = "date_suspended")
    private Date dateSuspended;

    @Column(name = "date_deleted")
    private Date dateDeleted;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "override_by")
    private Integer overrideBy;

    @Column(name = "override_comment")
    private String overrideComment;

    @Column(name = "override_date")
    private Date overrideDate;

    @Column(name = "override_payment")
    private boolean overridePayment;

    @Column(name = "is_processed")
    private boolean isProcessed;

    @Column(name = "reason_cancelled")
    private String reasonCancelled;

    @Column(name = "reason_suspended")
    private String reasonSuspended;

    @Column(name = "reason_deleted")
    private String reasonDeleted;

    @Column(name = "request_source")
    private Integer requestSource;

    @Column(name = "row_comment")
    private String rowComment;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "source_id")
    private Integer sourceId;

    @Column(name = "is_suspended")
    private boolean isSuspended;

    @Column(name = "time_processed")
    private Date timeProcessed;

    @Column(name = "time_requested")
    private Date timeRequested;

    @Column(name = "trx_ref_number")
    private String trxRefNumber;

    @Column(name = "free_offer_log_id")
    private Long freeOfferLogId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "member_email")
    private Integer memberEmail;

    @Column(name = "member_mobile_number")
    private Integer memberMobileNumber;

    @Column(name = "agent_id")
    private Integer agentId;

    @Column(name = "request_response")
    private String requestResponse;

    @Column(name = "trx_id")
    private String trxId;

    @Column(name = "institution_code")
    private String institutionCode;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "package_id")
    private Integer packageId;

    @Column(name = "agent_branch_id")
    private Integer agentBranchId;

    @Column(name = "agent_rep_id")
    private Integer agentRepId;

    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "outbound_status")
    private Integer outboundStatus;

    @Column(name = "institution_pay_cug")
    private boolean institutionPayCug;

    @Column(name = "subscription_service_log")
    private Integer subscriptionServiceLog;

    @Column(name = "promotion_id")
    private Integer promotionId;

    @Column(name = "promo_code_id")
    private Integer promoCodeId;

    @Column(name = "from_free_promotion_service_ref")
    private String fromFreePromotionServiceRef;

    @Column(name = "to_free_promotion_service_ref")
    private String toFreePromotionServiceRef;

    @Column(name = "discounted")
    private Boolean discounted;

    @Column(name = "discounted_amount", precision = 19, scale = 2)
    private BigDecimal discountedAmount;


    public ServiceRequest() {
    }
}
