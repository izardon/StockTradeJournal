package org.izardon.adapter.controller.rest.springboot.stockaccount.create;

import org.izardon.usecase.stockaccount.create.CreateStockAccountInput;
import org.izardon.usecase.stockaccount.create.CreateStockAccountOutput;
import org.izardon.usecase.stockaccount.create.CreateStockAccountUseCase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "${CORS_URLS}")
public class CreateStockAccountController {
    private CreateStockAccountUseCase createStockAccountUseCase;

    @Autowired
    public CreateStockAccountController(CreateStockAccountUseCase createStockAccountUseCase) {
        this.createStockAccountUseCase = createStockAccountUseCase;
    }

    @PostMapping(path = "/${STOCK_TRADE_JOURNAL_PREFIX}/stock-account-list", produces = "application/json")
    public String createStockAccount(@RequestBody String stockAccountInfo) {
        CreateStockAccountInput input = new CreateStockAccountInput();
        CreateStockAccountOutput output = new CreateStockAccountOutput();

        String name = "";
        try {
            JSONObject stockAccountJSON = new JSONObject(stockAccountInfo);
            name = stockAccountJSON.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        input.setName(name);
        createStockAccountUseCase.execute(input, output);

        return output.getId();
    }
}
