package br.com.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.domain.Cidade;
import br.com.cursomc.domain.Cliente;
import br.com.cursomc.domain.Endereco;
import br.com.cursomc.domain.Estado;
import br.com.cursomc.domain.ItemPedido;
import br.com.cursomc.domain.Pagamento;
import br.com.cursomc.domain.PagamentoComBoleto;
import br.com.cursomc.domain.PagamentoComCartao;
import br.com.cursomc.domain.Pedido;
import br.com.cursomc.domain.Produto;
import br.com.cursomc.domain.enums.EstadoPagamento;
import br.com.cursomc.domain.enums.TipoCliente;
import br.com.cursomc.repositories.CategoriaRepository;
import br.com.cursomc.repositories.CidadeRepository;
import br.com.cursomc.repositories.ClienteRepository;
import br.com.cursomc.repositories.EnderecoRepository;
import br.com.cursomc.repositories.EstadoRepository;
import br.com.cursomc.repositories.ItemPedidoRepository;
import br.com.cursomc.repositories.PagamentoRepository;
import br.com.cursomc.repositories.PedidoRepository;
import br.com.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
	
	Categoria categoria1 = new Categoria(null, "Informática");
	Categoria categoria2 = new Categoria(null, "Escritório");
	Categoria categoria3 = new Categoria(null, "Cama, mesa e banho");
	Categoria categoria4 = new Categoria(null, "Eletrônicos ");
	Categoria categoria5 = new Categoria(null, "Jardinagem");
	Categoria categoria6 = new Categoria(null, "Decoração");
	Categoria categoria7 = new Categoria(null, "Perfumaria");
		
	Produto produto1 = new Produto(null, "Computador", 2000.00);
	Produto produto2 = new Produto(null, "Impressora", 800.00);
	Produto produto3 = new Produto(null, "Mouse", 80.00);
	Produto produto4 = new Produto(null, "Mesa de escritório", 300.00);
	Produto produto5 = new Produto(null, "Toalha", 50.00);
	Produto produto6 = new Produto(null, "Colcha", 200.00);
	Produto produto7 = new Produto(null, "Tv true color", 1200.00);
	Produto produto8 = new Produto(null, "Roçadeira", 800.00);
	Produto produto9 = new Produto(null, "Abajour", 100.00);
	Produto produto10 = new Produto(null, "Pendente", 180.00);
	Produto produto11 = new Produto(null, "Shampoo", 90.00);
	

	categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
	categoria2.getProdutos().addAll(Arrays.asList(produto2, produto4));
	categoria3.getProdutos().addAll(Arrays.asList(produto5, produto6));
	categoria4.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3,produto7 ));
	categoria5.getProdutos().addAll(Arrays.asList(produto8));
	categoria6.getProdutos().addAll(Arrays.asList(produto9,produto10));
	categoria7.getProdutos().addAll(Arrays.asList(produto11));
	

	produto1.getCategoria().addAll(Arrays.asList(categoria1,categoria4 ));
	produto2.getCategoria().addAll(Arrays.asList(categoria1, categoria2, categoria4));
	produto3.getCategoria().addAll(Arrays.asList(categoria1, categoria4));
	produto4.getCategoria().addAll(Arrays.asList(categoria2));
	produto5.getCategoria().addAll(Arrays.asList(categoria3));
	produto6.getCategoria().addAll(Arrays.asList(categoria3));
	produto7.getCategoria().addAll(Arrays.asList(categoria4));
	produto8.getCategoria().addAll(Arrays.asList(categoria5));
	produto9.getCategoria().addAll(Arrays.asList(categoria6));
	produto10.getCategoria().addAll(Arrays.asList(categoria6));
	produto10.getCategoria().addAll(Arrays.asList(categoria7));

	categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, 
			categoria4, categoria5, categoria6, categoria7));
	produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4,
			produto5, produto6, produto7, produto8 ,produto9, produto10, produto11));

	Estado estado1 = new Estado(null, "Minas Gerais");
	Estado estado2 = new Estado(null, "São Paulo");

	Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
	Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
	Cidade cidade3 = new Cidade(null, "Campinas", estado2);

	estado1.getCidades().addAll(Arrays.asList(cidade1));
	estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
	
	estadoRepository.saveAll(Arrays.asList(estado1,estado2));
	cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
	
	Cliente cliente1 = new Cliente(null, "Maria de Ruthe", "adrianaolindo18@gmail.com", "529.169.230-80", TipoCliente.PESSOA_FISICA);
	cliente1.getTelefones().addAll(Arrays.asList("(12) 3456-7891", "(19) 8765-4321"));
	
	Endereco endereco1 = new Endereco(null, "Rua das Flores", "300", "Apto 303", "Jardim Rosa", "40321-165", cliente1, cidade2);
	Endereco endereco2 = new Endereco(null, "Avenida Cardoso", "105", "Sala 808", "Centro", "38777-012", cliente1, cidade1);
	
	cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));
	
	clienteRepository.saveAll(Arrays.asList(cliente1));
	enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Pedido pedido1 = new Pedido(null, sdf.parse("05/10/2023 15:27"), cliente1, endereco1);
	Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2023 19:35"), cliente1, endereco2);
	
	Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
	pedido1.setPagamento(pagamento1);
	
	Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("06/10/2023 00:00"), null);
	pedido2.setPagamento(pagamento2);
	
	cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
	
	pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
	pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
	
	ItemPedido item1 = new ItemPedido(pedido1, produto1, 00.00, 1, 2000.00);
	ItemPedido item2 = new ItemPedido(pedido1, produto3, 00.00, 2, 80.00);
	ItemPedido item3 = new ItemPedido(pedido2, produto2, 100.00, 1, 800.00);
	
	pedido1.getItens().addAll(Arrays.asList(item1,item2));
	pedido2.getItens().addAll(Arrays.asList(item3));
	
	produto1.getItens().addAll(Arrays.asList(item1));
	produto2.getItens().addAll(Arrays.asList(item3));
	produto3.getItens().addAll(Arrays.asList(item2));
	
	itemPedidoRepository.saveAll(Arrays.asList(item1,item2,item3));
	
}

}
