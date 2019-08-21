package com.aycap.helloworld.entity

import javax.persistence.*

@Entity
class Hello(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Column
        val name: String
)