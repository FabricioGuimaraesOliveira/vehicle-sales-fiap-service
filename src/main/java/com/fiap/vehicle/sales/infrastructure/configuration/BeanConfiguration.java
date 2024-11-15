package com.fiap.vehicle.sales.infrastructure.configuration;


import com.fiap.vehicle.sales.domain.entity.pagamento.gateway.PagamentoGateway;
import com.fiap.vehicle.sales.domain.entity.veiculo.gateway.VehicleGateway;
import com.fiap.vehicle.sales.infrastructure.mercadopago.gateway.MercadoPagoGateway;
import com.fiap.vehicle.sales.infrastructure.pagamento.gateway.PagamentoDataBaseRepository;
import com.fiap.vehicle.sales.infrastructure.veiculo.gateway.VeiculoDataBaseRepository;
import com.fiap.vehicle.sales.usecases.pagamento.PagamentoUseCase;
import com.fiap.vehicle.sales.usecases.veiculo.VehicleSalesUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Configuration
public class BeanConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public VehicleGateway createVehicleGateway(DynamoDbEnhancedClient enhancedClient, ModelMapper mapper,
											   @Value("${dynamodb.tablename}") String tableName) {
		return new VeiculoDataBaseRepository(enhancedClient, mapper, tableName);
	}
	@Bean
	public VehicleSalesUseCase createVehicleUseCase(VehicleGateway vehicleGateway) {
		return new VehicleSalesUseCase(vehicleGateway);
	}
	@Bean
	PagamentoGateway createPagamentoGateway(DynamoDbEnhancedClient enhancedClient, ModelMapper mapper,
											@Value("${dynamodb.pagamento.tablename}") String tableName) {
		return new PagamentoDataBaseRepository(enhancedClient, mapper, tableName);
	}
//
//

	@Bean
	PagamentoUseCase createPagamentoUseCase(PagamentoGateway pagamentoGateway, VehicleGateway vehicleGateway, MercadoPagoGateway mercadoPagoGateway) {
		return new PagamentoUseCase(pagamentoGateway,vehicleGateway,mercadoPagoGateway);
	}
}
