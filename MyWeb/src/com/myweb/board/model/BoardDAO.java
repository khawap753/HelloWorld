package com.myweb.board.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class BoardDAO {

	public DataSource ds;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BoardDAO dao = new BoardDAO();

	private BoardDAO() {
		// 커넥션 풀 꺼내오는 작업
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BoardDAO getInstance() {
		return dao;
	}

	public void regist(String writer, String title, String content) {
		String sql = "insert into t_board(num, writer, title, content) VALUES(T_BOARD_SEQ.nextval, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);

			// 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}

	// 총 게시물 수를 구해오는 메서드
	public int getTotal() {
		int total = 0;
		String sql = "select count(*) as total from t_board";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return total;
	}

	public ArrayList<BoardVO> getList(int pageNum) {
		ArrayList<BoardVO> list = new ArrayList<>();
//		String sql = "select * from t_board order by num desc";
		String sql = "select *\r\n" + "from(select rownum as rn, num, writer, title, content, regdate, hit\r\n"
				+ "        from(select *\r\n" + "                from t_board\r\n"
				+ "                order by num desc\r\n" + "        )\r\n" + ")\r\n" + " where rn > ? and rn <= ?;";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum - 1) * 10);
			pstmt.setInt(2, (pageNum) * 10);

			rs = pstmt.executeQuery();

			while (rs.next()) { // 결과값이 여러개이기 때문.
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");

				BoardVO vo = new BoardVO(num, writer, title, content, regdate, hit);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	public BoardVO contentBoard(String bnum) {
		BoardVO vo = new BoardVO();
		String sql = "select * from t_board where num=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bnum));
			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과값이 여러개이기 때문.
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");

				// vo에 저장한 값 저장.
				vo.setNum(num);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setRegdate(regdate);
				vo.setHit(hit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;

	}

	public void updateBoard(String num, String writer, String title, String content) {
		String sql = "update t_board set writer=?, title=?, content=? where num=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(num));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}

	public void deleteBoard(String num) {
		String sql = "delete from t_board where num=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}

	public void upHit(String num) {
		String sql = "update t_board set hit = hit+1 where num = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}

}
