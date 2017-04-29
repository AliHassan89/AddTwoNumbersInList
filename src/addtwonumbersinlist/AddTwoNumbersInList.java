/**
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
 * 
*/
package addtwonumbersinlist;

/**
 *
 * @author Ali
 */
public class AddTwoNumbersInList 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        
        l1.val = 1;
        //l1.next = new ListNode(8);
        //l1.next.next = new ListNode(3);
        
        l2.val = 9;
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(4);
        
        ListNode sum = addTwoNumbers(l1, l2);
        
        while(sum != null)
        {
            System.out.print(sum.val);
            sum = sum.next;
        }
    }
    
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        double result;
        double carry = 0;
        ListNode resultantNode = new ListNode();
        ListNode tmp = resultantNode;
        while(l1 != null)
        {
            if(l2 == null)
                result = l1.val + carry;
            else
                result = l1.val + l2.val + carry;

            carry = 0;
            if(result > 9)
            {
                carry = Math.floor(result / 10);
                result = result % 10;
            }

            while(resultantNode.next != null)
            {
                resultantNode = resultantNode.next;
            }

            resultantNode.val = (int) result;

            l1 = l1.next;
            if(l2 != null)
            {
                l2 = l2.next;
            }
            if(l1 != null)
            {
                resultantNode.next = new ListNode();
            }
        }
        
        while(l2 != null)
        {
            result = l2.val + carry;
            carry = 0;
            if(result > 9)
            {
                carry = Math.floor(result / 10);
                result = result % 10;
            }
            
            while(resultantNode.next != null)
            {
                resultantNode = resultantNode.next;
            }
            resultantNode.next = new ListNode();
            resultantNode.next.val = (int) result;
            
            l2 = l2.next;         
        }
        
        if(carry > 0)
        {
            while(resultantNode.next != null)
            {
                resultantNode = resultantNode.next;
            }
            resultantNode.next = new ListNode();
            resultantNode.next.val = (int) carry;
        }
        
        return tmp;
    }
    
}
