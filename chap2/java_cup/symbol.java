����   4pB
 C
 �D	 �E
 �FG
 F	 �HI
 	F	 �JK
 F	 �LM
 F	 �N	 �OP
 �QR
 �ST
 �UV
 W	 X	 Y
Z[\]	 ^_
 !F`
 !a
 !bc
 !d
 e	 f	 g
 �h	 f
 zij	 ^k	 l
 �mn	 .o	 gp	 6q	 r
 �s	 6t	 ^uv	 6wxy
 �z{
 �|}
 �~
 ���
 ���
 ���
 ���
 ���
 ���
 ���
 ���
 ���
 ���
 ���
 ��	 @g	 H�	 H^���	 c�	 H�	��
 z��	���	 c���	 J�	 J�	�^
 ��	 J�	 J^����	 �	 L��	 L^��	 L�	�Y��	����	����	 N�	 P�	 Pg�	 P^���	 R�	 R^�	 R�	 R��	 T�	 T^�	 T�
Z�	 V�
 ��	 �Y	 V^��
 ��
Z�	 V��	 V�
Z�	 X^�	 Z�	��
 ��	��	 Z�	 \�	 \^�	 \���	 \����
 ���
 ��	 ��	 �^��	 ��
 �����
 ��
 �F	 �Y
�d
 ��	 �^�
 ��
 ��	 ��	 ��
 ��
 ��
 ���	�Y	��
 6�	��	 ��
 ��	 ��	 �Y	 �^�� 
 c	 �
 �	 ��	

 �
 �	 �Y	 �^	 �	 �^	 ��	 �^
 .� env LSemant/Env; 
loopNumber I INT LTypes/Type; STRING NIL VOID <init> (LErrorMsg/ErrorMsg;)V Code LineNumberTable (LSemant/Env;)V transVar (LAbsyn/Var;)LTranslate/ExpTy; StackMapTable $(LAbsyn/SimpleVar;)LTranslate/ExpTy;\ '(LAbsyn/SubscriptVar;)LTranslate/ExpTy;V� #(LAbsyn/FieldVar;)LTranslate/ExpTy;p transExp (LAbsyn/Exp;)LTranslate/ExpTy; !(LAbsyn/VarExp;)LTranslate/ExpTy; !(LAbsyn/IntExp;)LTranslate/ExpTy; $(LAbsyn/StringExp;)LTranslate/ExpTy; !(LAbsyn/NilExp;)LTranslate/ExpTy; "(LAbsyn/CallExp;)LTranslate/ExpTy;� checkInt (LTranslate/ExpTy;I)LAbsyn/Exp;  (LAbsyn/OpExp;)LTranslate/ExpTy; $(LAbsyn/RecordExp;)LTranslate/ExpTy; !(LAbsyn/SeqExp;)LTranslate/ExpTy; $(LAbsyn/AssignExp;)LTranslate/ExpTy;  (LAbsyn/IfExp;)LTranslate/ExpTy; #(LAbsyn/WhileExp;)LTranslate/ExpTy; !(LAbsyn/ForExp;)LTranslate/ExpTy; #(LAbsyn/BreakExp;)LTranslate/ExpTy; !(LAbsyn/LetExp;)LTranslate/ExpTy; #(LAbsyn/ArrayExp;)LTranslate/ExpTy; transDec (LAbsyn/Dec;)LAbsyn/Exp; (LAbsyn/VarDec;)LAbsyn/Exp; (LAbsyn/TypeDec;)LAbsyn/Exp;�� transTypeFields !(LAbsyn/FieldList;)LTypes/RECORD;  (LAbsyn/FunctionDec;)LAbsyn/Exp;� transTy (LAbsyn/Ty;)LTypes/Type; (LAbsyn/NameTy;)LTypes/Type; (LAbsyn/RecordTy;)LTypes/Type; (LAbsyn/ArrayTy;)LTypes/Type; 
SourceFile Semant.java 
Semant/Env	 	Types/INT Types/STRING 	Types/NIL 
Types/VOID �  Absyn/SimpleVar Absyn/SubscriptVar Absyn/FieldVar Translate/ExpTy !"#$% Semant/Entry Semant/VarEntry& java/lang/StringBuilder Undefined var"'(') "! (transVar SimpleVar)*+,-./012 Types/ARRAY 3Not a Array's SubscriptVar! (transVar SubscriptVar)34 6SubscriptVar isn't a interger! (transVar SubscriptVar)5 Types/RECORD6"7"89:; " $"doesn't exiset! (transVar FieldVar)< %Unknown FieldVar! (transVar FieldVar) Absyn/VarExp Absyn/IntExp Absyn/NilExp Absyn/StringExp Absyn/CallExp Absyn/OpExp" Absyn/RecordExp# Absyn/SeqExp% Absyn/AssignExp& Absyn/IfExp' Absyn/WhileExp( Absyn/ForExp) Absyn/BreakExp* Absyn/LetExp+ Absyn/ArrayExp-=" 
Function " &" doesn't be found! (transExp CallExp) Semant/FunEntry>;?@A4BC 3Functon parameter doesn't match! (transExp CallExp):@ :Functoin parameter number does't match! (transExp CallExp)D )Unknown function call! (transExp CallExp) 
Not a int!EF4G !H4 Can't compare VOID! Can't both be NIL! Types does't match! Types unsuitable!I J" 
Types/Type Undefined Type " "! (transExp RecordExp)KL undefined Field!" " (transExp RecordExp)M4 Type " $"doesn't match! (transExp RecordExp):L 1Number of Type does't macht! (transExp RecordExp) #"does't exiet! (transExp RecordExp)N@O4 Semant/LoopVarEntry ,Can't assign a loopvar! (transExp AssignExp) )Can't assign a VOID! (transExp AssignExp) 0Different type between ':=' (transExp AssignExp)P4 ,If test must be a interger! (transExp IfExp)Q4R4 <Then part must be same type with else part! (transExp IfExp) 2While test must be a interger! (transExp WhileExp)S4T/U.0 )For test must be a var! (transExp ForExp) .For test must be a interger! (transExp ForExp)VWXY4 -For end must be a interger! (transExp ForExp)Z Break should be in a Loop![\A]./:\^4 %The size of array should be interger! "is not a array! 
Types/NAME The element type dosen't match! Absyn/VarDec Absyn/TypeDec.1 Absyn/FunctionDec.7 Dec " ." doesn't have a init value! (transDec VarDec)J_9; !Type not match! (transDec VarDec) VarDec " ," has a nil as init value! (transDec VarDec) java/util/ArrayList`a9 ." has been defined already! (transDec TypeDec)b9cde.fgV9:hi " is Loop!(transDec TypeDec)j:klk45D_ 0" has been defined already! transDec FunctionDec Semant/StdFuncEntry 
Functoin " +" is a StdFuncEntry! (transDec FunctionDec)mdno Param " 2" has already been defined! (transDec FunctionDec) Undefined type " " (transDev FunctionDec) 5Return valiable doesn't match! (transDev FunctionDec) Absyn/NameTy Absyn/RecordTy9< Absyn/ArrayTy9? Unknown type " " (transTy NameTy)Kk " (transTy RecordTy) Field "  " is defined! (transTy RecordTy) $" doesn't exites! (transTy RecordTy) %Type doesn't exist! (transTy ArrayTy) Semant/Semant java/lang/Object Absyn/ExpList Absyn/FieldExpList Absyn/DecList Absyn/FieldList ()V (LAbsyn/Exp;LTypes/Type;)V vEnv LSymbol/Table; name LSymbol/Symbol; Symbol/Table get #(LSymbol/Symbol;)Ljava/lang/Object; pos append -(Ljava/lang/String;)Ljava/lang/StringBuilder; -(Ljava/lang/Object;)Ljava/lang/StringBuilder; toString ()Ljava/lang/String; errorMsg (ILjava/lang/String;)V ty var LAbsyn/Var; actual ()LTypes/Type; index LAbsyn/Exp; element 	fieldName field equals (Ljava/lang/Object;)Z tail LTypes/RECORD; 	fieldType func formals args LAbsyn/ExpList; head coerceTo (LTypes/Type;)Z result oper left 	Absyn/Exp right tEnv typ fields LAbsyn/FieldExpList; init list exp test 
thenclause 
elseclause body 
beginScope LAbsyn/VarDec; (LTypes/Type;)V put $(LSymbol/Symbol;Ljava/lang/Object;)V hi endScope decs LAbsyn/DecList; LAbsyn/Dec; size LAbsyn/NameTy; Symbol/Symbol contains add (LSymbol/Symbol;)V next LAbsyn/TypeDec; 
LAbsyn/Ty; bind isLoop ()Z ,(LSymbol/Symbol;LTypes/Type;LTypes/RECORD;)V LAbsyn/FieldList; params (LTypes/RECORD;LTypes/Type;)V LAbsyn/FunctionDec; clear ! � �      �                          	 
   *     *� Y+� � *� �          
   
   b     6*� *� Y� � *� 	Y� 
� *� Y� � *� Y� � *+� �                 %  0    
   x     =+� � *+� � �+� � *+� � �+� � *+� � �� Y*� � �                    '  0        
   �     `*� � +� � � M,� 
,� � 6*� +�  � !Y� "#� $+� � %&� $� '� (� Y*� � �� Y,� � )� �            !  # C $ P '   	 � 2   
   �     u*+� *� +M,� ,N,� ,� -� .� *� +� /0� (� Y*� � �*+� 1� 2M,� ,� � *� +� /3� (� Y*� � �� Y-� -� .� 4� �      * 
   , 	 -  /  1 ( 2 5 4 > 5 H 7 U 8 b :    � 5,   
   �     �*+� 5� +M,� ,� -� 6� o,� ,� -� 6N-� -� 7+� 8� 9� � -� :N���-� 6*� +� ;� !Y� "<� $+� 8� %=� $� '� (� Y*� � �� Y-� >� �*� +� ;?� (� Y*� � �      2    ? 	 @  B ! C % D 6 C > E B G h H u K � N � O    � !6�   
  �     �+� @� *+� @� A�+� B� *+� B� C�+� D� *+� D� E�+� F� *+� F� G�+� H� *+� H� I�+� J� *+� J� K�+� L� *+� L� M�+� N� *+� N� O�+� P� *+� P� Q�+� R� *+� R� S�+� T� *+� T� U�+� V� *+� V� W�+� X� *+� X� Y�+� Z� *+� Z� [�+� \� *+� \� ]�� Y*� � �      ~    S  T  U  V   W ' X 0 Y 7 Z @ [ G \ P ] W ^ ` _ g ` p a w b � c � d � e � f � g � h � i � j � k � l � m � n � o � p � q       
   !     	*+� ^� +�          v   
   %     � Y*� � �          z   
   %     � Y*� � �          ~   
   %     � Y*� � �          �   
  �     �*� � +� _� � M,� 6*� +� `� !Y� "a� $+� _� %b� $� '� (� Y*� � �,� c� �,� cN-� d:+� e:� N� I*� f� 2:� ,� >� g� *� +� `h� (� Y*� � �� ::� i:���� � *� +� `j� (� Y*� � �� Y-� k� �*� +� `l� (� Y*� � �      R    �  �  � < � I � P � U � [ � a � k � v � � � � � � � � � � � � � � � � � � �    � I� >	�    ! 
   ?     +� ,� � *� m� (�          � 
 �  �      " 
      �MN+� n�     �       	   8   m   �   �    �  l  �    h**+� o� 2+� o� p� qW**+� r� 2+� r� p� qW� Y*� � �**+� o� 2+� o� p� qW**+� r� 2+� r� p� qW� Y*� � �**+� o� 2+� o� p� qW**+� r� 2+� r� p� qW� Y*� � �**+� o� 2+� o� p� qW**+� r� 2+� r� p� qW� Y*� � �*+� o� 2M*+� r� 2N,� ,� -� � -� ,� -� � *� +� st� (,� ,� -� � -� ,� -� � *� +� su� (,� ,-� ,� g� D,� ,� -� � -� ,� -� 6� *,� ,� -� 6� -� ,� -� � *� +� sv� (� Y*� � �*+� o� 2M*+� r� 2N,� ,� � -� ,� � *� +� st� (,� ,� � -� ,� � *� +� su� (,� ,-� ,� g� 8,� ,� � -� ,� 6� $,� ,� 6� -� ,� � *� +� sv� (� Y*� � �*+� o� 2M*+� r� 2N,� ,� � -� ,� � $,� ,� 	� -� ,� 	� *� +� sw� (� Y*� � �*+� o� 2M*+� r� 2N,� ,� � -� ,� � $,� ,� 	� -� ,� 	� *� +� sw� (� Y*� � �*+� o� 2M*+� r� 2N,� ,� � -� ,� � $,� ,� 	� -� ,� 	� *� +� sw� (� Y*� � �*+� o� 2M*+� r� 2N,� ,� � -� ,� � $,� ,� 	� -� ,� 	� *� +� sw� (� Y*� � �� Y*� � �      � =   �  � @ � T � h � u � � � � � � � � � � � � � � � � � �& �@ �M �g �t �� �� �� �� �� �� �� �� � � �$ �2 �F �Z �g �t �} �� �� �� �� �� �� �� �� � � � �% �. �B �V �c �p �y �� �� �� �� �� �   - #� @4444+&'% !%%%%  # 
       �*� � x+� y� � zM,� 6*� +� {� !Y� "|� $+� y� %}� $� '� (� Y*� � �,� -� 6� �,� -� 6N+� ~:-� �� �� -� 7� 9� 7*� +� {� !Y� "�� $� � %�� $� '� (� Y*� � �-� >� -:*� �� 2� ,:� g� F� 6� � � 6*� +� {� !Y� "�� $-� 7� %�� $� '� (� Y*� � �-� :N� �:��D-� � *� +� {�� (� Y*� � �� Y,� �*� +� {� !Y� "�� $+� y� %�� $� '� (� Y*� � �      b      < I S
 [ a j y � � � � � � ) 6!C#M%s&   & 	� I� $� K� 0� 2� 	  % 
   |     6+� 
+� �� � Y*� � �M+� �N-� *-� f� 2M-� iN���,�         + , . / #0 ,/ 41    � �   & 
   �     �*+� �� 2M*+� �� +N+� �� � >*� � +� �� � � � :� �� *� +� ��� (� Y*� � �,� ,*� � g� *� +� ��� (-� ,,� ,� g� $-� ,� 6� ,� ,� � *� +� ��� (,�      6   6 	7 8 : 5; == J> WA eB rC �D �E �F    � W!  ' 
   �     �*+� �� 2M,� ,� � *� +� ��� (� Y*� � �*+� �� 2N+� �� K*+� �� 2:-� ,� ,� g� 2-� ,� � (� ,� � *� +� ��� (� Y*� � �-�      2   K 	L N  O -Q 6R =T GU VV kX xY �\    � -� W  ( 
   �     W*+� �� 2M,� ,� � *� +� ��� (� Y*� � �*Y� `� *+� �� 2W*Y� d� � Y*� � �      "   a 	b d  e -g 7h @j Jk    � -  ) 
  9     �*Y� `� *� � � �*+� �� �W*� � +� �� �� � M,� � *� +� ��� (� ?,� � )� � *� +� ��� (� "*� � +� �� �� �Y,� � )� �� �*+� �� 2N-� ,� � *� +� ��� (*+� �� 2W*� � � �*Y� d� � Y*� � �      B   p 
q r s 2t 9v I{ V| f} � �� �� �� �� �� ��    � I�   * 
   J     !*� � *� +� ��� (� Y*� � �         � � �      + 
   �     X*� � x� �*� � � �+� �M,� *,� �� �W,� �M���*+� �� 2M*� � � �*� � x� �� Y,� ,� �      & 	  � 
� � � &� .� 7� A� K�    � ,�   - 
  =     �*+� �� 2M,� ,� � *� +� ��� (� Y*� � �*� � x+� �� � zN-� -� .� 6*� +� �� !Y� "<� $+� �� %�� $� '� (� Y*� � �-:-� �� 	-� -:� .� 6� .� 4*+� �� 2� ,� g� *� +� ��� (� Y*� � �� Y� �      >   � 	� �  � -� ?� I� o� |� � �� �� �� �� ��    � -� N� :  ./ 
   m     2+� �� *+� �� ��+� �� *+� �� ��+� �� *+� �� ���         � � � �  � '� 0�      .0 
  P     �+� �� +*� +� �� !Y� "�� $+� �� %�� $� '� (�*+� �� 2MN+� �� :*+� �� �� -N,� ,-� g� U-� 6� ,� ,� � D*� +� ��� (�,� ,� � +*� +� �� !Y� "¶ $+� �� %ö $� '� (�-� *� � +� �� Y-� Ķ �� *� � +� �� Y,� ,� Ķ ��      F   � � -� /� 8� :� A� M� X� i� v� x� �� �� �� �� ��    /� 91  .1 
  �    � �Y� �M+N-� g,-� Ƕ ȶ ə ,*� +� ʻ !Y� "�� $-� Ƕ %˶ $� '� (� (,-� Ƕ ȶ �W*� � x-� ǻ �Y-� Ƿ Ͷ �-� �N���+N-� P-� �� %*� � x-� Ƕ � �� �Y-� Ƿ Ͷ Ч *� � x-� Ƕ � �*-� ϶ Ѷ �-� �N���+N-� U*� � x-� Ƕ � �:� ҙ 2*� +� ʻ !Y� "�� $-� Ƕ %Ӷ $� '� (*� � �-� �N����      R   � � � � B� E� Q� j� r� x� � �� �� �� �� �� �����   ' � 
23:$� � 3,� � 3� M�   45 
   �     g+� �� 6Y+� �*� � x+� ն � z� �MN,N+� �:� 5-� 6Y� �*� � x� ն � z� ֵ :-� :N� �:���,�      "   �   & ( 3 V [ e    � '6� 6  .7 
  �    �� �Y� �M� �Y� �N+:� �*� ض �:*� ڶ �:,� ۶ ȶ ə .*� � ܻ !Y� "a� $� ۶ %ݶ $� '� (� u,� ۶ ȶ �W*� � � ۶ � :� 5� ޙ -*� +� ܻ !Y� "߶ $� ۶ %� $� '� (� *� � � ۻ cY� � �� �:��2+:�*� � � �-� �*� ڶ �:� �:� �-� Զ ȶ ə .*� � ܻ !Y� "� $� Զ %� $� '� (� l,� Զ ȶ �W*� � x� ն � z:� .*� � ܻ !Y� "� $� Զ %� $� '� (� *� � � Ի Y� Ķ �� �:��Q*� � 2:� ,� g� *� � �� (*� � � �� �:����      � #      # . = e h u � � � � � �  �" �# �$%' )H*K,X-l0q1�2�%�6�9�:�;� �=   H � 228� T� W� � 	� 8� $6>� P� � 	� %�   9: 
   p     5+� � *+� � ��+� � *+� � �+� � *+� �� �*� �         B C D E  F 'G 0H      9; 
   �     L+� *� �*� � x+� � � zM,� .*� +� � !Y� "� $+� � %� $� '� (*� �,�         M 	N O Q ER JT   	 	� @  9< 
      n*� � x+� � ն � 1*� +� �� !Y� "� $+� � Զ %�� $� '� (*� �*� � � �MN� 6Y+� � �*� � x+� � ն � z� �YMN� �Y� �:+� � Զ ȶ �W+� � �:� �� Զ ȶ ə -*� +� �� !Y� "�� $� Զ %�� $� '� (� �� Զ ȶ �W*� � x� ն � z:� -*� +� �� !Y� "�� $� ն %�� $� '� (� 3*� � � Ի Y� Ķ �-� 6Y� �� ֵ :-� :N� �:��9*� � � �,�      ^   Y [ =\ B^ L_ P` va b �c �e �g �h �j �k �l �n%o(q@rSsXcbulv   + � B� U =>26  >� P� /� 	  9? 
   g     1*� � x+� �� � zM,� *� +� ��� (*� �� .Y,� ��         { | ~ # (�    � ( @   A