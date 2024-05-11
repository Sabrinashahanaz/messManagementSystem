/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu19216454.controller;

import bd.edu.diu19216454.model.Payment;

/**
 *
 * @author Shahanaz
 */
public class PaymentController {
    public boolean save(Payment payment){
        return payment.save();
}
}
