package nz.co.skytv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@ApiModel("Generic Response")
public class GenericResponse<T> {
    @ApiModelProperty(value = "The business data returned by this endpoint", required = true)
    private T data;

    public T getData() {
        return data;
    }
    public GenericResponse<T> withData(T data) {
        this.data = data;
        return this;
    }
}
