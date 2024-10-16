package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements DAO {
	/* DAO <-> DB */
	
	// DB 연결객체
	private Connection conn;
	// sql 구문 실행시키는 기능을 가진 객체
	private PreparedStatement pst;
	// 쿼리문 저장 스트링
	private String query = "";
	
	public ProductDAOImpl() {
		// DBConnection class 생성(싱글톤) 연결
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	//sql 처리
	@Override
	public int insert(Product p) {
		// product 객체를 등록하고, isOk를 리턴
		System.out.println("insert DAOImpl success!!");
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			// ? 반드시 순서대로 처리 (자료형을 기재) 1부터 시작
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			// insert. update, delete => 처리만... (1 row(s) affected)
			// 결과의 행 수만 리턴 => executeUpdate();  int로 리턴
			return pst.executeUpdate();			
		} catch (SQLException e) {
			// insert error
			System.out.println("insert error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> selectList() {
		// DB에서 리스트를 가져와서 리턴
		System.out.println("list DAOImpl success!!");
		query = "select * from product order by pno desc";
		List<Product> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			// select => 목록 => excuteQuery();  ResultSet로 리턴
			ResultSet rs = pst.executeQuery();
			//ResultSet => List로 변환 (pno, pname, price)
			while(rs.next()) {
				list.add(new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("list error!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product selectProduct(int pno) {
		System.out.println("product DAOImpl success!!");
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
//			Product p = new Product();
//			ResultSet rs = pst.executeQuery();
//			p.setPno(rs.getInt(pno));
			ResultSet rs = pst.executeQuery(); //ResultSet => 배열로 처리함 그래서 while/if 해줘야함
			if(rs.next()) {
				Product p = new Product(
						rs.getInt("pno"), 
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));	
				return p;
			}
		} catch (SQLException e) {
			System.out.println("product error!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Product p) {
		System.out.println("update DAOImpl success!!");
		query = "update product set pname=?,"
				+ " price=?, madeby=?,"
				+ " regdate=now() where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error!!");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int pno) {
		System.out.println("delete DAOImpl success!!");
		query = "delete from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete error!!");
			e.printStackTrace();
		}
		return 0;
	}
	//실제로는 delete를 많이 사용하지않고 삭제테이블을 만들어서 사용함
	// -> 메뉴들이 계절별로 있으니 삭제되면 나중에 다시 등록을 해야하는데 
	// 그러면 pno가 갱신되므로 삭제는 잘 사용하지 않는다 (나중에 사용 가능성이 있으므로)


}
