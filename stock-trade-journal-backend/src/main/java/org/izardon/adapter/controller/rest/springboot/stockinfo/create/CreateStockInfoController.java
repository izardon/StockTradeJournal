package org.izardon.adapter.controller.rest.springboot.stockinfo.create;


import org.izardon.usecase.stockinfo.create.CreateStockInfoInput;
import org.izardon.usecase.stockinfo.create.CreateStockInfoOutput;
import org.izardon.usecase.stockinfo.create.CreateStockInfoUseCase;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${CORS_URLS}")
public class CreateStockInfoController {
    private CreateStockInfoUseCase createStockInfoUseCase;

    @Autowired
    public CreateStockInfoController(CreateStockInfoUseCase createStockInfoUseCase) {
        this.createStockInfoUseCase = createStockInfoUseCase;
    }

    @PostMapping(path = "/${STOCK_TRADE_JOURNAL_PREFIX}/stock-account-list/{stockAccountId}", produces = "application/json")
    public String createStockInfo(@PathVariable("stockAccountId") String stockAccountId,
                                  @RequestBody String stockInfoBody) {
        CreateStockInfoInput input = new CreateStockInfoInput();
        CreateStockInfoOutput output = new CreateStockInfoOutput();


        String stockNumber = "";
        String stockName = "";
        try {
            JSONObject stockInfoJSON = new JSONObject(stockInfoBody);
            stockNumber = stockInfoJSON.getString("stockNumber");
            stockName = stockInfoJSON.getString("stockName");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        input.setStockAccountId(stockAccountId);
        input.setStockNumber(stockNumber);
        input.setStockName(stockName);
        createStockInfoUseCase.execute(input, output);

        return output.getStockId();
    }
}
