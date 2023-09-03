package org.izardon.adapter.controller.rest.springboot.accountstock.create;


import org.izardon.usecase.accountstock.create.CreateAccountStockInput;
import org.izardon.usecase.accountstock.create.CreateAccountStockOutput;
import org.izardon.usecase.accountstock.create.CreateAccountStockUseCase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${CORS_URLS}")
public class CreateAccountStockController {
    private CreateAccountStockUseCase createAccountStockUseCase;

    @Autowired
    public CreateAccountStockController(CreateAccountStockUseCase createAccountStockUseCase) {
        this.createAccountStockUseCase = createAccountStockUseCase;
    }

    @PostMapping(path = "/${STOCK_TRADE_JOURNAL_PREFIX}/stock-account-list/{stockAccountId}", produces = "application/json")
    public String createAccountStock(@PathVariable("stockAccountId") String stockAccountId,
                                     @RequestBody String accountStockBody) {
        CreateAccountStockInput input = new CreateAccountStockInput();
        CreateAccountStockOutput output = new CreateAccountStockOutput();


        String stockCode = "";
        String stockName = "";
        try {
            JSONObject accountStock = new JSONObject(accountStockBody);
            stockCode = accountStock.getString("stockCode");
            stockName = accountStock.getString("stockName");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        input.setStockAccountId(stockAccountId);
        input.setStockCode(stockCode);
        input.setStockName(stockName);
        createAccountStockUseCase.execute(input, output);

        return output.getStockId();
    }
}
