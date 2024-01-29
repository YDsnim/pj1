package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vendor {

    @Id
    @Column()
    private String businessLicense ;	//사업자번호
    @Column()
    private String vendorName;//	거래처 이름
    @Column()
    private String vendorAddress;//	거래처 주소
    @Column()
    private String vendorPnumber;	//거래처 전화번호
    @Column()
    private String vendorEmail ;	//거래처 이메일
    @Column()
    private String pic ;// 거래담당자


}
