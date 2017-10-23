#!/usr/bin/sh
#     -----------------------------------------------------------------------
#                  -=- boz_0rpv.sh -=-
#     -----------------------------------------------------------------------
#     Description du module : Lancement du batch de load du SAS RPV 
#     Numero de Version      : V 1.0
#     -----------------------------------------------------------------------
#     Parametres en entree   : 
#     Parametres en sortie   : 						
#                            : 0 -> OK
#                              1 -> ANOMALIE
#     Fichiers modifies      :
#     ------------------------------------------------------------------------
#     Auteur        : HIN
#     Date creation : 08/10/2007
#     ------------------------------------------------------------------------
#
#     Modifications     :
#
#     Date   : 
#     Auteur : 
#     Objet  : Load du SAS
#
#     ------------------------------------------------------------------------
# Positionnement des variables
# ----------------------------
export JARFILE=$UNXJAVALIB/boz-rpv.jar
echo "debut traitement boz_0rpv.sh `date`" >>$BOZ_REP_LOG/$BOZ_FIC_LOG

#-- lancement du batch java
echo "lancement :  /usr/lpp/java/J1.4/bin/java -showversion -cp $CLASSPATH -Xmx256m -DBOZ_FIC_LOG=$BOZ_FIC_LOG -DBOZ_REP_LOG=$BOZ_REP_LOG -DBOZ_ORACLE_DRIVER=$BOZ_ORACLE_DRIVER -DBOZ_ALIM_USER=$BOZ_ALIM_USER -DBOZ_ALIM_MDP=$BOZ_ALIM_MDP -DBOZ_PREFIXE_IN=$BOZ_PREFIXE_IN -DBOZ_REP_IN=$BOZ_REP_IN -DBOZ_REP_REJET=$BOZ_REP_REJET -DBOZ_REP_VALIDE=$BOZ_REP_VALIDE -DBOZ_ORACLE_SID=$BOZ_ORACLE_SID -DBOZ_SCHEMA_SAS=$BOZ_SCHEMA_SAS -DBOZ_PRD=$BOZ_PRD com.inetpsa.boz.rpv.start.RpvStart >>$BOZ_REP_LOG/$BOZ_FIC_LOG"
/usr/java14/bin/java -showversion -cp $CLASSPATH -Xmx256m -DBOZ_FIC_LOG=$BOZ_FIC_LOG -DBOZ_REP_LOG=$BOZ_REP_LOG -DBOZ_ORACLE_DRIVER=$BOZ_ORACLE_DRIVER -DBOZ_ALIM_USER=$BOZ_ALIM_USER -DBOZ_ALIM_MDP=$BOZ_ALIM_MDP -DBOZ_PREFIXE_IN=$BOZ_PREFIXE_IN -DBOZ_REP_IN=$BOZ_REP_IN -DBOZ_REP_REJET=$BOZ_REP_REJET -DBOZ_REP_VALIDE=$BOZ_REP_VALIDE -DBOZ_ORACLE_SID=$BOZ_ORACLE_SID  -DBOZ_SCHEMA_SAS=$BOZ_SCHEMA_SAS -DBOZ_PRD=$BOZ_PRD com.inetpsa.boz.rpv.start.RpvStart >>$BOZ_REP_LOG/$BOZ_FIC_LOG
RETOUR=$? 
if [ $RETOUR -ne 0 ]; then
   echo "============================================" >> $BOZ_REP_LOG/$BOZ_FIC_LOG
   echo "=           A T T E N T I O N  ! ! !       = " >> $BOZ_REP_LOG/$BOZ_FIC_LOG
   echo "============================================" >> $BOZ_REP_LOG/$BOZ_FIC_LOG
   echo "Fin anormale du traitement boz_0rpv.sh `date`" >> $BOZ_REP_LOG/$BOZ_FIC_LOG
   echo "============================================" >> $BOZ_REP_LOG/$BOZ_FIC_LOG
   exit $RETOUR
fi

echo "Fin normale traitement boz_0rpv.sh `date` \n\n" >> $BOZ_REP_LOG/$BOZ_FIC_LOG
exit 0
