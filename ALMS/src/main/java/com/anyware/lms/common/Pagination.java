package com.anyware.lms.common;

public class Pagination
{

	private int listSize = 10; // 초기값으로 목록개수를 10으로 셋팅

	private int rangeSize = 10; // 초기값으로 페이지범위를 10으로 셋팅

	private int page;

	private int range;

	private int listCnt;

	private int pageCnt;

	private int startPage;

	private int startList;

	private int endPage;

	private boolean prev;

	private boolean next;

	
	public int getRangeSize()
	{

		return rangeSize;

	}

	public int getPage()
	{

		return page;

	}

	public void setPage(int page)
	{

		this.page = page;

	}

	public int getRange()
	{

		return range;

	}

	public void setRange(int range)
	{

		this.range = range;

	}

	public int getStartPage()
	{

		return startPage;

	}

	public void setStartPage(int startPage)
	{

		this.startPage = startPage;

	}

	public int getEndPage()
	{

		return endPage;

	}

	public void setEndPage(int endPage)
	{

		this.endPage = endPage;

	}

	public boolean isPrev()
	{

		return prev;

	}

	public void setPrev(boolean prev)
	{

		this.prev = prev;

	}

	public boolean isNext()
	{

		return next;

	}

	public void setNext(boolean next)
	{

		this.next = next;

	}

	public int getListSize()
	{

		return listSize;

	}

	public void setListSize(int listSize)
	{

		this.listSize = listSize;

	}

	public int getListCnt()
	{

		return listCnt;

	}

	public void setListCnt(int listCnt)
	{

		this.listCnt = listCnt;

	}

	public int getStartList()
	{

		return startList;

	}

	/**
	 * @Date : 2020. 6. 11.
	 * @Name : pageInfo
	 * @param page 현재 페이지 정보
	 * @param range 현재 페이지 범위 정보
	 * @param listCnt 게시물 총 개수
	====================
	 * @Description
	 * 
	 */
	public void pageInfo(int page, int range, int listCnt)
	{

		this.page = page;

		this.range = range;

		this.listCnt = listCnt;

		/** 전달 받은 전체 게시물 개수(listCnt)와 기본값으로 설정한 한 페이지당 목록 개수(listSize)를 이용해 전체 페이지 개수(pageCnt)를 구합니다. */
		this.pageCnt = (int) Math.ceil(listCnt / listSize);

		/** 각 페이지 범위의 시작 번호를 구하는 방법입니다.*/
		this.startPage = (range - 1) * rangeSize + 1;

		/**각 페이지 범위의 마지막 번호를 구하는 방법입니다. 마지막 페이지의 번호를 구하는 이유는 다음에 나올 [다음] 버튼의 활성화 여부를 판단하기 위해서 입니다.*/
		this.endPage = range * rangeSize;

		/** 게시판의 시작번호를 따로 구하는 이유는 현재 MySQL을 이용해 원하는 목록을 가져 오기 위해서 입니다. */
		this.startList = (page - 1) * listSize;

		// 이전 버튼 상태
		this.prev = range == 1 ? false : true;

		// 다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;

		if (this.endPage > this.pageCnt)
		{
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
}
