#flatten Multilevel linked liae
"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""
"""
Rexursive approach
Whenever there is a child present add the first child as next of parent and traverse the child list until its tailn and then add tail.next = parent next (saved in a variable) if next of parent was not None
""""


class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        if head is None:
            return None
        self.helper(head)
        return head
                
    def helper(self, curr):
        while curr is not None:
            lastnode = curr
            nxt = curr.next
            if curr.child is not None:
                curr.next = curr.child
                curr.next.prev = curr
                curr.child = None
                curr = self.helper(curr.next)
                if nxt is not None:
                    curr.next = nxt
                    nxt.prev = curr
                    curr = nxt
            else:
                curr = curr.next
        return lastnode
