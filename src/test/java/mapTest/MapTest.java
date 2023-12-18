package mapTest;

import com.github.wnameless.json.flattener.JsonFlattener;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MapTest {

    public static void main(String[] args) {
        Map<String, BigDecimal> rules = new HashMap<String, BigDecimal>();

        rules.put("acquisitionFeeMarkupAllowed", null);

        rules.put("maximumAmountFinanced", BigDecimal.valueOf(9));

        rules.put("maximumBackEndAdvance", BigDecimal.valueOf(8));

        rules.put("maximumCapCostReduction", null);

        rules.put("maximumExcessWearAndTear", BigDecimal.valueOf(10));

        rules.put("maximumSoftAddAllowance", BigDecimal.valueOf(100));

        rules.put("minimumAmountFinanced", BigDecimal.valueOf(1000));

        rules.put("minimumVehicleValue", null);

        rules.put("maximumAnnualMileage",null);

        rules.put("maximumGap", null);


        Map<String, List<String>> map=new HashMap<>();
        map.put("GM",List.of("dealType","driveOff","totalMiles"));
        map.put("Honda", List.of("buyRate","rolledOverCashDeficiency"));

        List<String> paths = map.entrySet().stream().filter(k -> k.getKey().equalsIgnoreCase("GM"))
                .map(entry -> entry.getValue()).flatMap(val -> val.stream()).collect(Collectors.toList());
        //List<String> newList = list.stream().flatMap(val -> val.stream()).collect(Collectors.toList());
        //System.out.println(newList);
        System.out.println(paths);
        BiFunction<String, String, String> getJsonValues=(json, jsonPath)->{
            Map<String, ?> jsonMap = JsonFlattener.flattenAsMap(json);
            String str = jsonMap.entrySet().stream()
                    .filter(path -> path.getKey().contains(jsonPath))
                    //.map(m -> m.getValue())
                    .collect(Collectors.toList()).get(0).toString();
            return str;
        };
       // paths.stream().parallel().map(path-> getJsonAsMap(json(),path)).forEach(System.out::println);
        paths.stream().parallel().map(path-> getJsonValues.apply(json(),path)).forEach(System.out::println);
    }


    public static String getJsonAsMap(String json, String jsonPath){
        Map<String, ?> jsonMap = JsonFlattener.flattenAsMap(json);
        String str = jsonMap.entrySet().stream()
                .filter(path -> path.getKey().contains(jsonPath))
                //.map(m -> m.getValue())
                .collect(Collectors.toList()).get(0).toString();
        return str;
    }

    public static String json(){
        return "{\n" +
                "    \"data\": {\n" +
                "        \"dealResponseList\": [\n" +
                "            {\n" +
                "                \"accessoryDetails\": {\n" +
                "                    \"accessoryList\": [\n" +
                "                        {\n" +
                "                            \"id\": null,\n" +
                "                            \"isResidualized\": false,\n" +
                "                            \"isTaxUpfront\": true,\n" +
                "                            \"isTaxable\": true,\n" +
                "                            \"isUpfront\": true,\n" +
                "                            \"name\": \"Premium All-Weather Cargo Area Mat in Jet Black with Volt Script\",\n" +
                "                            \"price\": 0.0,\n" +
                "                            \"residualAppliesToMSRP\": false,\n" +
                "                            \"residualValue\": null\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": null,\n" +
                "                            \"isResidualized\": false,\n" +
                "                            \"isTaxUpfront\": false,\n" +
                "                            \"isTaxable\": true,\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"name\": \"Driving lamps\",\n" +
                "                            \"price\": 0.0,\n" +
                "                            \"residualAppliesToMSRP\": false,\n" +
                "                            \"residualValue\": null\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": null,\n" +
                "                            \"isResidualized\": false,\n" +
                "                            \"isTaxUpfront\": false,\n" +
                "                            \"isTaxable\": false,\n" +
                "                            \"isUpfront\": true,\n" +
                "                            \"name\": \"Custom wheels\",\n" +
                "                            \"price\": 245.2,\n" +
                "                            \"residualAppliesToMSRP\": false,\n" +
                "                            \"residualValue\": null\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": null,\n" +
                "                            \"isResidualized\": false,\n" +
                "                            \"isTaxUpfront\": false,\n" +
                "                            \"isTaxable\": false,\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"name\": \"Sun roof\",\n" +
                "                            \"price\": 323.32,\n" +
                "                            \"residualAppliesToMSRP\": false,\n" +
                "                            \"residualValue\": null\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"disclosureValue\": \"Estimated tax includes state, county, and city taxes based on the location of the dealer. Accessory pricing does not include dealer installation and labor fees, which may be extra.\"\n" +
                "                },\n" +
                "                \"amountFinanced\": 51348.62,\n" +
                "                \"annualMileage\": {\n" +
                "                    \"additionalMiles\": -3000,\n" +
                "                    \"disclosureValue\": \"$0.25 per mile over 12,000 miles\",\n" +
                "                    \"totalMiles\": 12000,\n" +
                "                    \"yearlyBaseMiles\": 15000\n" +
                "                },\n" +
                "                \"cashDeficiency\": 127.37,\n" +
                "                \"ccrDetails\": {\n" +
                "                    \"capCostReduction\": 3000.0,\n" +
                "                    \"customerCash\": {\n" +
                "                        \"toCCR\": 0.0,\n" +
                "                        \"toDriveOff\": 3000.0,\n" +
                "                        \"total\": 3000.0\n" +
                "                    },\n" +
                "                    \"customerCashCCR\": 0.0,\n" +
                "                    \"rebateCCR\": 3000.0,\n" +
                "                    \"rebates\": {\n" +
                "                        \"toCCR\": 3000.0,\n" +
                "                        \"toDriveOff\": 0.0,\n" +
                "                        \"total\": 3000.0\n" +
                "                    },\n" +
                "                    \"totalAmount\": 6000.0,\n" +
                "                    \"totalCCR\": 3000.0,\n" +
                "                    \"totalDriveOff\": 3000.0,\n" +
                "                    \"tradeIn\": {\n" +
                "                        \"toCCR\": 0.0,\n" +
                "                        \"toDriveOff\": 0.0,\n" +
                "                        \"total\": 0.0\n" +
                "                    },\n" +
                "                    \"tradeInCCR\": 0.0\n" +
                "                },\n" +
                "                \"currency\": \"USD\",\n" +
                "                \"customerCash\": 3000,\n" +
                "                \"customerCashPercentage\": null,\n" +
                "                \"customerSpecificPrice\": null,\n" +
                "                \"dealInfoException\": null,\n" +
                "                \"dealInterestRate\": {\n" +
                "                    \"amountFinancedPct\": null,\n" +
                "                    \"buyRate\": 0.002579,\n" +
                "                    \"dealInterestType\": \"MF\",\n" +
                "                    \"disclosureValue\": null,\n" +
                "                    \"financeReserve\": -164.77,\n" +
                "                    \"markup\": 0.0,\n" +
                "                    \"participation\": 80,\n" +
                "                    \"reserveMethodType\": \"MARKUP_BASED_WITH_BUYRATE_SELLRATE\",\n" +
                "                    \"securityDepositAdjustment\": null,\n" +
                "                    \"sellRate\": 0.002579\n" +
                "                },\n" +
                "                \"dealInterestRateAPR\": {\n" +
                "                    \"amountFinancedPct\": null,\n" +
                "                    \"buyRate\": 6.19,\n" +
                "                    \"dealInterestType\": \"APR\",\n" +
                "                    \"disclosureValue\": null,\n" +
                "                    \"financeReserve\": -164.77,\n" +
                "                    \"markup\": 0.0,\n" +
                "                    \"participation\": 80,\n" +
                "                    \"reserveMethodType\": \"MARKUP_BASED_WITH_BUYRATE_SELLRATE\",\n" +
                "                    \"securityDepositAdjustment\": null,\n" +
                "                    \"sellRate\": 6.19\n" +
                "                },\n" +
                "                \"dealInterestRateMF\": {\n" +
                "                    \"amountFinancedPct\": null,\n" +
                "                    \"buyRate\": 0.002579,\n" +
                "                    \"dealInterestType\": \"MF\",\n" +
                "                    \"disclosureValue\": null,\n" +
                "                    \"financeReserve\": -164.77,\n" +
                "                    \"markup\": 0.0,\n" +
                "                    \"participation\": 80,\n" +
                "                    \"reserveMethodType\": \"MARKUP_BASED_WITH_BUYRATE_SELLRATE\",\n" +
                "                    \"securityDepositAdjustment\": null,\n" +
                "                    \"sellRate\": 0.002579\n" +
                "                },\n" +
                "                \"dealType\": \"LEASE\",\n" +
                "                \"driveOff\": 3127.37,\n" +
                "                \"driveOffReduction\": null,\n" +
                "                \"errorMessage\": null,\n" +
                "                \"extraCashInfoList\": [],\n" +
                "                \"feeDetail\": {\n" +
                "                    \"disclosureValue\": {\n" +
                "                        \"LICENSE_FEE\": \"If displayed, the amount reflects an estimate of registration fees due at delivery, including title, license, and other fees, based on the purchaser’s residence and applicable state requirements. Registration fees are payable at delivery or when the purchaser registers the vehicle. Please contact dealer for details.\",\n" +
                "                        \"REGISTRATION_CHARGES\": \"If displayed, the amount reflects an estimate of registration fees due at delivery, including title, license, and other fees, based on the purchaser’s residence and applicable state requirements. Registration fees are payable at delivery or when the purchaser registers the vehicle. Please contact dealer for details.\",\n" +
                "                        \"TITLE_FEE\": \"If displayed, the amount reflects an estimate of registration fees due at delivery, including title, license, and other fees, based on the purchaser’s residence and applicable state requirements. Registration fees are payable at delivery or when the purchaser registers the vehicle. Please contact dealer for details.\"\n" +
                "                    },\n" +
                "                    \"feeList\": [\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"documentation Fee\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"isTaxUpfront\": true,\n" +
                "                            \"isTaxable\": true,\n" +
                "                            \"isUpfront\": true,\n" +
                "                            \"name\": \"documentation Fee\",\n" +
                "                            \"source\": \"Custom\",\n" +
                "                            \"value\": 889.0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"title fee\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"isTaxUpfront\": false,\n" +
                "                            \"isTaxable\": true,\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"name\": \"title fee\",\n" +
                "                            \"source\": \"Custom\",\n" +
                "                            \"value\": 0.0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"documentation Fee2\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"isTaxUpfront\": false,\n" +
                "                            \"isTaxable\": false,\n" +
                "                            \"isUpfront\": true,\n" +
                "                            \"name\": \"\",\n" +
                "                            \"source\": \"Custom\",\n" +
                "                            \"value\": 400.0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"Registration Fee\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"isTaxUpfront\": false,\n" +
                "                            \"isTaxable\": false,\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"name\": \"Registration Fee\",\n" +
                "                            \"source\": \"Custom\",\n" +
                "                            \"value\": 122.12\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"feeListByType\": [\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"title fee\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"name\": \"title fee\",\n" +
                "                            \"value\": 0.0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"documentation Fee\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"name\": \"documentation Fee\",\n" +
                "                            \"value\": 889.0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"documentation Fee2\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"name\": \"documentation Fee2\",\n" +
                "                            \"value\": 400.0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"disclosureType\": \"Registration Fee\",\n" +
                "                            \"disclosureValue\": null,\n" +
                "                            \"name\": \"Registration Fee\",\n" +
                "                            \"value\": 122.12\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"fiProductList\": [\n" +
                "                    {\n" +
                "                        \"disclosureType\": \"Insurance\",\n" +
                "                        \"id\": null,\n" +
                "                        \"isHardAdd\": false,\n" +
                "                        \"isTaxUpfront\": false,\n" +
                "                        \"isTaxable\": true,\n" +
                "                        \"isUpfront\": false,\n" +
                "                        \"isWarrantyTaxApplicable\": false,\n" +
                "                        \"name\": \"Insurance\",\n" +
                "                        \"price\": 0.0,\n" +
                "                        \"residualizableValue\": null,\n" +
                "                        \"taxPercent\": null,\n" +
                "                        \"taxPercentBreakup\": null\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"disclosureType\": \"MAINTENANCE\",\n" +
                "                        \"id\": null,\n" +
                "                        \"isHardAdd\": false,\n" +
                "                        \"isTaxUpfront\": false,\n" +
                "                        \"isTaxable\": false,\n" +
                "                        \"isUpfront\": false,\n" +
                "                        \"isWarrantyTaxApplicable\": false,\n" +
                "                        \"name\": \"maintenance\",\n" +
                "                        \"price\": 100.0,\n" +
                "                        \"residualizableValue\": null,\n" +
                "                        \"taxPercent\": null,\n" +
                "                        \"taxPercentBreakup\": null\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"disclosureType\": \"warranty\",\n" +
                "                        \"id\": null,\n" +
                "                        \"isHardAdd\": false,\n" +
                "                        \"isTaxUpfront\": true,\n" +
                "                        \"isTaxable\": true,\n" +
                "                        \"isUpfront\": true,\n" +
                "                        \"isWarrantyTaxApplicable\": false,\n" +
                "                        \"name\": \"warranty\",\n" +
                "                        \"price\": 525.0,\n" +
                "                        \"residualizableValue\": null,\n" +
                "                        \"taxPercent\": null,\n" +
                "                        \"taxPercentBreakup\": null\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"disclosureType\": \"other fni\",\n" +
                "                        \"id\": null,\n" +
                "                        \"isHardAdd\": false,\n" +
                "                        \"isTaxUpfront\": false,\n" +
                "                        \"isTaxable\": false,\n" +
                "                        \"isUpfront\": true,\n" +
                "                        \"isWarrantyTaxApplicable\": false,\n" +
                "                        \"name\": \"other fni\",\n" +
                "                        \"price\": 243.22,\n" +
                "                        \"residualizableValue\": null,\n" +
                "                        \"taxPercent\": null,\n" +
                "                        \"taxPercentBreakup\": null\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"financeCharge\": 7687.39,\n" +
                "                \"gmInfoDetails\": {\n" +
                "                    \"dealerAttributes\": null,\n" +
                "                    \"msrpAttributes\": null\n" +
                "                },\n" +
                "                \"grossCapCost\": 54543.33,\n" +
                "                \"id\": \"1234\",\n" +
                "                \"lenderType\": \"GMF\",\n" +
                "                \"loanToValueRatio\": 1.0,\n" +
                "                \"minIncentiveExpirationDate\": null,\n" +
                "                \"monthlyPaymentDetails\": {\n" +
                "                    \"disclosureValue\": null,\n" +
                "                    \"monthlyPayment\": 766.27\n" +
                "                },\n" +
                "                \"monthlyPaymentWithoutTax\": 766.27,\n" +
                "                \"msrpDetails\": {\n" +
                "                    \"disclosureValue\": \"Tax, Title, and License are extra.\",\n" +
                "                    \"msrp\": 51558,\n" +
                "                    \"vehicleMsrp\": 51558\n" +
                "                },\n" +
                "                \"netCapCost\": 51348.62,\n" +
                "                \"noOfPayments\": 36,\n" +
                "                \"onePayMonthlyPayment\": null,\n" +
                "                \"outOfPocketCash\": 3000.0,\n" +
                "                \"paymentBreakups\": {\n" +
                "                    \"driveOff\": [\n" +
                "                        {\n" +
                "                            \"breakupItemList\": null,\n" +
                "                            \"total\": 1289.0,\n" +
                "                            \"type\": \"FEES\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"breakupItemList\": null,\n" +
                "                            \"total\": 245.2,\n" +
                "                            \"type\": \"ACCESSORIES\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"breakupItemList\": null,\n" +
                "                            \"total\": 768.22,\n" +
                "                            \"type\": \"FNI\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"breakupItemList\": null,\n" +
                "                            \"total\": 58.68,\n" +
                "                            \"type\": \"TAXES\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"breakupItemList\": null,\n" +
                "                            \"total\": 766.27,\n" +
                "                            \"type\": \"MONTHLY_PAYMENT\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"grossCapCost\": null,\n" +
                "                    \"netCapCost\": null,\n" +
                "                    \"outOfPocketCash\": [\n" +
                "                        {\n" +
                "                            \"breakupItemList\": null,\n" +
                "                            \"total\": 3000,\n" +
                "                            \"type\": \"CUSTOMER_CASH\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"paymentFrequency\": \"MONTHLY\",\n" +
                "                \"priceAfterOffers\": {\n" +
                "                    \"amount\": 51558,\n" +
                "                    \"offerType\": \"OEM_OFFER_PRICE\"\n" +
                "                },\n" +
                "                \"priceItems\": null,\n" +
                "                \"rebateList\": [\n" +
                "                    {\n" +
                "                        \"certificateCode\": \"21-40GFB-5\",\n" +
                "                        \"disclosureValue\": null,\n" +
                "                        \"expirationDate\": null,\n" +
                "                        \"id\": \"Lease Cash|21-40GFB-5\",\n" +
                "                        \"marketIncentiveName\": null,\n" +
                "                        \"name\": \"GM Financial Supported Lease Program\",\n" +
                "                        \"type\": \"CustomerRebate\",\n" +
                "                        \"useCashAsCCR\": true,\n" +
                "                        \"value\": 3000.0\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"residual\": {\n" +
                "                    \"additionalMileageRate\": 0.25,\n" +
                "                    \"adjustedMsrp\": 51558.0,\n" +
                "                    \"adjustedResidual\": {\n" +
                "                        \"percentage\": 0.0,\n" +
                "                        \"value\": 0.0\n" +
                "                    },\n" +
                "                    \"baseResidual\": {\n" +
                "                        \"percentage\": 61.0,\n" +
                "                        \"value\": 31450.38\n" +
                "                    },\n" +
                "                    \"demoMiles\": 0,\n" +
                "                    \"residualizableOptionsValue\": 0,\n" +
                "                    \"totalResidual\": {\n" +
                "                        \"percentage\": 61.0,\n" +
                "                        \"value\": 31450.38\n" +
                "                    }\n" +
                "                },\n" +
                "                \"rewardValue\": 0.0,\n" +
                "                \"rolledOverCashDeficiency\": 127.37,\n" +
                "                \"securityDeposit\": 0,\n" +
                "                \"sellingPriceDetails\": {\n" +
                "                    \"disclosureValue\": \"Tax, Title, and License are extra.\",\n" +
                "                    \"sellingPrice\": 51558\n" +
                "                },\n" +
                "                \"standardProgramFound\": false,\n" +
                "                \"taxExemptionSettings\": {\n" +
                "                    \"applyCleanAlternativeFuelTaxExemption\": null,\n" +
                "                    \"collectTaxOnCashDeficiency\": null,\n" +
                "                    \"collectTaxOnNegativeTradeEquity\": false,\n" +
                "                    \"isFiProductIncludedInTaxExemption\": false,\n" +
                "                    \"isLenderTaxExemptFeeTaxUpfront\": true,\n" +
                "                    \"isRebateIncludedInTaxExemption\": true,\n" +
                "                    \"isTradeInIncludedInTaxExemption\": false,\n" +
                "                    \"isTradeInIncludedInTaxExemptionForNegativeTrade\": false,\n" +
                "                    \"lenderTaxExemptFeeTaxPercentage\": 0,\n" +
                "                    \"lenderTaxExemptionAmount\": 0,\n" +
                "                    \"lenderTaxExemptionPercentage\": 0\n" +
                "                },\n" +
                "                \"taxInfo\": {\n" +
                "                    \"dealAddOnsCappedTax\": 0.0,\n" +
                "                    \"dealAddOnsUpfrontTax\": 58.68,\n" +
                "                    \"disclosureValue\": \"Estimated tax includes state, county, and city taxes based on the location of the dealer. Taxes due at delivery may vary due to the purchaser’s residence, the amount of the trade-in allowance, and other factors. Taxes may be payable at delivery and/or when the purchaser titles the vehicle. Please contact dealer for details.\",\n" +
                "                    \"flatTax\": null,\n" +
                "                    \"taxBreakUp\": {\n" +
                "                        \"accessoriesTaxBreakUp\": [],\n" +
                "                        \"feesTaxBreakUp\": [\n" +
                "                            {\n" +
                "                                \"amount\": 36.89,\n" +
                "                                \"description\": \"State Tax\",\n" +
                "                                \"isUpfront\": true,\n" +
                "                                \"parentType\": \"SALES_TAX\",\n" +
                "                                \"percentage\": 4.15,\n" +
                "                                \"taxableBase\": null,\n" +
                "                                \"type\": \"STATE_TAX\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"fiproductTaxBreakUp\": [\n" +
                "                            {\n" +
                "                                \"amount\": 21.79,\n" +
                "                                \"description\": \"State Tax\",\n" +
                "                                \"isUpfront\": true,\n" +
                "                                \"parentType\": \"SALES_TAX\",\n" +
                "                                \"percentage\": 4.15,\n" +
                "                                \"taxableBase\": null,\n" +
                "                                \"type\": \"STATE_TAX\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    \"taxDetailsLIst\": [\n" +
                "                        {\n" +
                "                            \"amount\": 2020.44,\n" +
                "                            \"description\": \"Selling Price Sales Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": \"SALES_TAX\",\n" +
                "                            \"percentage\": 4.15,\n" +
                "                            \"taxableBase\": 48685.3,\n" +
                "                            \"type\": \"SP_SALES_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": 58.68,\n" +
                "                            \"description\": \"State Tax\",\n" +
                "                            \"isUpfront\": true,\n" +
                "                            \"parentType\": \"SALES_TAX\",\n" +
                "                            \"percentage\": 4.15,\n" +
                "                            \"taxableBase\": 1413.98,\n" +
                "                            \"type\": \"STATE_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": null,\n" +
                "                            \"description\": \"Single Article Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": \"SALES_TAX\",\n" +
                "                            \"percentage\": 0.0,\n" +
                "                            \"taxableBase\": null,\n" +
                "                            \"type\": \"SINGLE_ARTICLE_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": null,\n" +
                "                            \"description\": \"Local Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": \"SALES_TAX\",\n" +
                "                            \"percentage\": 0.0,\n" +
                "                            \"taxableBase\": null,\n" +
                "                            \"type\": \"LOCAL_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": null,\n" +
                "                            \"description\": \"Business Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": \"SALES_TAX\",\n" +
                "                            \"percentage\": 0.0,\n" +
                "                            \"taxableBase\": null,\n" +
                "                            \"type\": \"BUSINESS_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": null,\n" +
                "                            \"description\": \"State Business Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": \"SALES_TAX\",\n" +
                "                            \"percentage\": 4.15,\n" +
                "                            \"taxableBase\": null,\n" +
                "                            \"type\": \"STATE_BUSINESS_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": 97.37,\n" +
                "                            \"description\": \"BPOL Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": null,\n" +
                "                            \"percentage\": 0.2,\n" +
                "                            \"taxableBase\": 48685.0,\n" +
                "                            \"type\": \"BPOL_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": 58.68,\n" +
                "                            \"description\": \"Sales Tax\",\n" +
                "                            \"isUpfront\": true,\n" +
                "                            \"parentType\": null,\n" +
                "                            \"percentage\": 4.15,\n" +
                "                            \"taxableBase\": 1413.98,\n" +
                "                            \"type\": \"SALES_TAX\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"amount\": 2020.44,\n" +
                "                            \"description\": \"Sales Tax\",\n" +
                "                            \"isUpfront\": false,\n" +
                "                            \"parentType\": null,\n" +
                "                            \"percentage\": 4.15,\n" +
                "                            \"taxableBase\": 48685.3,\n" +
                "                            \"type\": \"SALES_TAX\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"totalTax\": 2176.49\n" +
                "                },\n" +
                "                \"taxPercentBreakup\": {\n" +
                "                    \"bpolTaxRate\": 0.2,\n" +
                "                    \"businessFnITaxRate\": 0,\n" +
                "                    \"businessOccupationTaxRate\": 0,\n" +
                "                    \"businessTaxRate\": 0.0,\n" +
                "                    \"ccrTaxRate\": 4.15,\n" +
                "                    \"cityTaxRate\": 0.0,\n" +
                "                    \"corporateActivityTaxRate\": null,\n" +
                "                    \"countyTaxRate\": 0.0,\n" +
                "                    \"docStampTaxRate\": null,\n" +
                "                    \"documentFeeTaxRate\": 0,\n" +
                "                    \"exciseTaxRate\": 0.0,\n" +
                "                    \"leaseTaxRate\": 4.15,\n" +
                "                    \"lenderAndMemberFeeTaxRate\": null,\n" +
                "                    \"lenderTaxExemptFeeTaxRate\": 0.0,\n" +
                "                    \"loanTaxRate\": null,\n" +
                "                    \"localFnITaxRate\": 0,\n" +
                "                    \"localTaxRate\": 0.0,\n" +
                "                    \"medTaxRate\": 0,\n" +
                "                    \"monthlyUseTaxRate\": 4.15,\n" +
                "                    \"motorVehicleTaxRate\": 0.0,\n" +
                "                    \"municipalTaxRate\": 0.0,\n" +
                "                    \"rtaTaxRate\": null,\n" +
                "                    \"rtdTaxRate\": null,\n" +
                "                    \"singleArticleTaxRate\": 0.0,\n" +
                "                    \"spdsTaxRate\": 0.0,\n" +
                "                    \"stateBusinessTaxRate\": 4.15,\n" +
                "                    \"stateFnITaxRate\": 0,\n" +
                "                    \"stateTaxRate\": 4.15,\n" +
                "                    \"vehicleInventoryTaxRate\": 0,\n" +
                "                    \"warrantyTaxRate\": 3.0,\n" +
                "                    \"wholesaleTaxRate\": 0\n" +
                "                },\n" +
                "                \"term\": 36,\n" +
                "                \"tradeInList\": [\n" +
                "                    {\n" +
                "                        \"actualCashValue\": 0,\n" +
                "                        \"allowance\": 0,\n" +
                "                        \"bodyClass\": null,\n" +
                "                        \"bookValue\": 0,\n" +
                "                        \"id\": null,\n" +
                "                        \"ownershipType\": \"Loan\",\n" +
                "                        \"payOff\": 0,\n" +
                "                        \"retainedEquity\": 0,\n" +
                "                        \"rvType\": null,\n" +
                "                        \"taxationType\": null\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"actualCashValue\": 0,\n" +
                "                        \"allowance\": 0,\n" +
                "                        \"bodyClass\": null,\n" +
                "                        \"bookValue\": 0,\n" +
                "                        \"id\": null,\n" +
                "                        \"ownershipType\": \"Loan\",\n" +
                "                        \"payOff\": 0,\n" +
                "                        \"retainedEquity\": 0,\n" +
                "                        \"rvType\": null,\n" +
                "                        \"taxationType\": null\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"tradeTaxExemption\": {\n" +
                "                    \"exemptedNumberOfPayments\": 0,\n" +
                "                    \"nonExemptedPayments\": 0,\n" +
                "                    \"numberOfPaymentsExempt\": 0,\n" +
                "                    \"partialExemptedTax\": 0.0,\n" +
                "                    \"partialTaxExemptPaymentValue\": 0.0,\n" +
                "                    \"partialTaxExemptedPayments\": 0,\n" +
                "                    \"taxExemptValue\": 0.0,\n" +
                "                    \"tradeTaxAllowanceExemptionAmount\": 0.0,\n" +
                "                    \"tradeTaxExemptionValue\": 0.0\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"status\": \"success\"\n" +
                "}";
    }
}
