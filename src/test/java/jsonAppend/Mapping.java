package jsonAppend;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Mapping {
    private Double amountFinanced;
    private Double monthlyPayment;
    private Double financeCharge;
}
