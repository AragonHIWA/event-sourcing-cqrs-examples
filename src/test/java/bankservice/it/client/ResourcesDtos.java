package bankservice.it.client;

import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;

public class ResourcesDtos {

    private final ObjectMapper objectMapper;

    public ResourcesDtos(ObjectMapper objectMapper) {
        this.objectMapper = checkNotNull(objectMapper);
    }

    public ObjectNode depositDto(BigDecimal amount) {
        ObjectNode newAccountDto = objectMapper.createObjectNode();
        return newAccountDto.put("amount", amount.doubleValue());
    }

    public ObjectNode withdrawalDto(BigDecimal amount) {
        ObjectNode newAccountDto = objectMapper.createObjectNode();
        return newAccountDto.put("amount", amount.doubleValue());
    }

    public ObjectNode clientDto(String name, String email) {
        ObjectNode newClientDto = objectMapper.createObjectNode();
        return newClientDto.put("name", name).put("email", email);
    }
}
