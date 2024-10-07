SELECT CATEGORY, SUM(SALES) AS 'TOTAL_SALES'
FROM BOOK, BOOK_SALES
WHERE BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
AND YEAR(SALES_DATE) = '2022'
AND MONTH(SALES_DATE) = '01'
GROUP BY CATEGORY
ORDER BY CATEGORY